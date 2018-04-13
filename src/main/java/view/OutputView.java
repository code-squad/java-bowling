package view;

import domain.Player;

public class OutputView {

    public static void printBoard(Player player) {
        System.out.println(player.getResult());
        //System.out.println(getTopMessage() + getResultMessage() + getResultScore());
    }

    private static String getTopMessage() {
        return "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n";
    }

    private static String getResultMessage() {

        return null;
    }

    private static String getResultScore() {

        return null;
    }

    private static String fillArea(String content) {
        int areaSize = 6;
        String out = String.format("%" + areaSize + "s%s%" + areaSize + "s", "", content, "");
        int mid = (out.length() / 2);
        int start = mid - (areaSize / 2);
        int end = start + areaSize;
        return out.substring(start, end);
    }
}
