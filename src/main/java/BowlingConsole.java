import domain.BowlingGame;
import view.Prompter;
import view.Validator;

public class BowlingConsole {

    public static void main(String[] args) {
        BowlingGame game = startGame();
    }

    private static BowlingGame startGame() {
        String playerName = takeName();
        BowlingGame game = new BowlingGame(playerName);

        for (int throwCount = 0; throwCount < 19; throwCount++) {
            int throwScore = takeThrowScore(throwCount);
            game.updateScores(throwScore, throwCount);
        }
        return game;
    }

    private static String takeName() {
        try {
            String playerName = Prompter.promptForPlayerNames();
            return Validator.validateName(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeName();
        }
    }

    private static int takeThrowScore(int throwCount) {
        try {
            String throwScore = Prompter.promptForThrowScore(throwCount + 1);
            return Validator.validateScore(throwScore);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeThrowScore(throwCount);
        }
    }
}
