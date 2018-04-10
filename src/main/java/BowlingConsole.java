import view.Prompter;
import view.Score;
import view.Validator;

public class BowlingConsole {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        String playerName = takeName();
        Score game = new Score(playerName);

        for (int throwCount = 0; throwCount < 21; throwCount++) {
            int throwScore = takeThrowScore(throwCount);
            game.updateScore(throwScore, throwCount);
        }
        if (game.isBonus()) {
            int bonusScore = takeBonusScore();
            game.updateScore(bonusScore, 21);
        }
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

    private static int takeBonusScore() {
        try {
            String throwScore = Prompter.promptForBonusScore();
            return Validator.validateScore(throwScore);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeBonusScore();
        }
    }
}
