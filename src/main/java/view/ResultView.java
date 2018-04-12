package view;

import domain.Frame;

import java.util.List;

public class ResultView {
    private static final int MAX_FRAME_NO = 10;
    private static final String UNPLAYED_FRAME = "      |";

    public static void printStatus(List<Frame> frames, String name, int frameNo) {
        System.out.println("\n| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(String.format("  %3s |", name));
        for (int index = 0; index < frameNo; index++) {
            if (index == MAX_FRAME_NO - 1) {
                sb.append(String.format("%-6s|", frames.get(index).toString()));
                break;
            }
            sb.append(String.format("  %-3s |", frames.get(index).toString()));
        }
        for (int index = 0; index < MAX_FRAME_NO - frameNo; index++) {
            sb.append(UNPLAYED_FRAME);
        }
        System.out.println(sb.toString());
    }
}
