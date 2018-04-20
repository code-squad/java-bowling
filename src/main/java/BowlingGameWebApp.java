import domain.BowlingGame;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class BowlingGameWebApp {
    private static List<BowlingGame> bowlingGames;
    private static int playerIndex;

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> {
            bowlingGames = new ArrayList<>();
            playerIndex = 0;
            return render(null, "/index.html");
        });

        post("/start", (request, response) -> {
            Arrays.stream(request.queryParams("players").split(", |,"))
                    .forEach(playerName -> bowlingGames.add(new BowlingGame(playerName)));

            Map<String, Object> model = new HashMap<>();
            model.put("bowlingGames", bowlingGames);
            model.put("player", bowlingGames.get(playerIndex).getPlayerName());
            model.put("currentFrameNumber", getCurrentFrameNumber());
            return render(model, "/play.html");
        });

        post("/throw", (request, response) -> {
            bowlingGames.get(playerIndex).play(Integer.parseInt(request.queryParams("throwingNo")));

            Map<String, Object> model = new HashMap<>();
            model.put("bowlingGames", bowlingGames);
            model.put("player", getNextPlayer());
            model.put("currentFrameNumber", getCurrentFrameNumber());
            return render(model, "/play.html");
        });
    }

    private static int getCurrentFrameNumber() {
        return bowlingGames.get(playerIndex).getFrames().size() + 1;
    }

    private static String getNextPlayer() {
        playerIndex = (playerIndex + 1) % bowlingGames.size();
        return bowlingGames.get(playerIndex).getPlayerName();
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
