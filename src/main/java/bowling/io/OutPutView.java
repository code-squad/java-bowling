package bowling.io;

import bowling.domain.Player;
import bowling.domain.ScoreSheet;

public class OutPutView {
    public static void printScoreSheetGuideLine() {
        System.out.println(String.format("| %.4s |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |", "NAME",1,2,3,4,5,6,7,8,9,10));
    }

    public static void printPlayerScoreSheet(Player player) {
        System.out.println(player.toString());
    }
}
