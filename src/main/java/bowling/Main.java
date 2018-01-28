package bowling;

import bowling.domain.BowlingGame;
import bowling.dto.Board;
import bowling.dto.CurrentPlayerInfo;
import bowling.view.InputView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            return render(new HashMap<>(), "/index.html");
        });

        post("/start", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String player = req.queryParams("players");
            BowlingGame bowlingGame = null;

            try {
                bowlingGame = new BowlingGame(InputView.getPlayer(player));
            } catch(RuntimeException e) {
                redirectToMainPage();
            }

            req.session().attribute("bowlingGame", bowlingGame);
            putInModel(bowlingGame, model);

            return render(model, "/play.html");
        });

        post("/throw", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            BowlingGame bowlingGame = req.session().attribute("bowlingGame");
            int pin = InputView.getPin(req.queryParams("throwingNo"));

            try {
                bowlingGame.rollBowlingBall(pin);
            } catch(RuntimeException e) {
                retry(bowlingGame);
            }

            putInModel(bowlingGame, model);
            return render(model, "/play.html");
        });
    }

    public static String render(Map<String, Object> model, String path) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, path));
    }

    private static String redirectToMainPage() {
        return render(new HashMap<>(), "/index.html");
    }

    private static String retry(BowlingGame bowlingGame) {
        Map<String, Object> model = new HashMap<>();

        putInModel(bowlingGame, model);

        return render(model, "/play.html");
    }

    private static void putInModel(BowlingGame bowlingGame, Map<String, Object> model) {
        Board board = bowlingGame.createBoard();
        CurrentPlayerInfo playerInfo = board.getCurrentPlayerInfo();
        model.put("currentPlayer", playerInfo.getName());
        model.put("currentFrameNo", playerInfo.getCurrentFrameNo());
        model.put("frameResult", board.getPlayerResults());
        model.put("isNotEnd", !bowlingGame.isGameEnd());
    }

/*    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame(InputView.getPlayer());
        OutputView.showScoreBoard(bowlingGame.createBoard());

        while(!bowlingGame.isGameEnd()) {
            OutputView.showPlayerTurnInfo(bowlingGame.createBoard());
            bowlingGame.rollBowlingBall(InputView.getPin());
            OutputView.showScoreBoard(bowlingGame.createBoard());
        }
    }*/
}
