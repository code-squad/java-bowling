package bowling.io;

import bowling.domain.Player;

import static java.lang.String.format;

public class OutPutView {
    public static void printScoreSheetGuideLine() {
        System.out.println(format("| %-5s|  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |  %02d  |", "NAME",1,2,3,4,5,6,7,8,9,10));
    }

    public static void printPlayerScoreSheet(Player player) {
        System.out.println(player.toString());
    }

    public static String frameFormat(String text) {
        return format("  %-4s|", text);
    }
}