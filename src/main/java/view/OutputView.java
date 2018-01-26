package view;

import model.BowlingGame;

public class OutputView {
    public static void showCurrentStatus(BowlingGame bowlingGame) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        System.out.println("| "+ bowlingGame.getPlayerName() + "  " + printScore(bowlingGame));
        System.out.println("|     " + printResult(bowlingGame));
    }

    private static String printScore(BowlingGame bowlingGame) {
        String scoreResult = "| ";
        for (String result : bowlingGame.getBowlingResultOnlyString()) {
            scoreResult += result + " | ";
        }

        return scoreResult;
    }

    private static String printResult(BowlingGame bowlingGame) {
        String scoreResult = " |";
        for (String score : bowlingGame.getTotalScore()) {
            scoreResult += String.format("%4s  |", score);
        }

        return scoreResult;
    }
}
