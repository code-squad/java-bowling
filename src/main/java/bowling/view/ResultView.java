package bowling.view;

import bowling.domain.Printable;

public class ResultView {

    public static void printScoreBoard(Printable player) {
        System.out.println(player.convertStatusToPrintable());
        System.out.println(player.convertScoreToPrintable());
    }
}