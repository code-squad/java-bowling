package bowling.view;

import bowling.domain.Printable;

public class ResultView {

    public static void printScoreBoard(Printable player) {
        System.out.println("| NAME |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |   10 |");
        System.out.println(player.convertStatusToPrintable());
        System.out.println(player.convertScoreToPrintable());
    }
}