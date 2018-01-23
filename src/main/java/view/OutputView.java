package view;

import model.BowlingGame;
import model.BowlingResult;

public class OutputView {
    public static void showCurrentStatus(BowlingGame bowlingGame) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        System.out.println("| "+ bowlingGame.getPlayerName() + "  " + printScore(bowlingGame));
    }

    private static String printScore(BowlingGame bowlingGame) {
        String scoreResult = "| ";
        for (String result : BowlingResult.getResult(bowlingGame)) {
            scoreResult += result + " | ";
        }

        return scoreResult;
    }
}
