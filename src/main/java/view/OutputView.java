package view;

import domain.Player;
import domain.frame.Frames;
import domain.frame.result.FrameResults;

public class OutputView {

    public static void printResult(Player player) {
        System.out.println(getTopMessage() + getResultMessage(player.getName(), player.getResults()));
    }

    private static String getTopMessage() {
        return "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n";
    }

    private static String getResultMessage(String name, FrameResults results) {
        StringBuilder builder = new StringBuilder();
        builder.append("|").append(fillArea(name));
        for (int frameIdx = 0; frameIdx < results.getMaxSaveSize(); frameIdx++) {
            builder.append("|").append(buildFrameResultMessage(results, frameIdx));
            if (Frames.isLast(frameIdx + 1)) {
                builder.append("|");
            }
        }
        return builder.toString();
    }

    private static String buildFrameResultMessage(FrameResults results, int frameIdx) {
        String resultContent = results.getFrameResultMessage(frameIdx);
        if (resultContent == null) {
            return fillArea("");
        }
        return fillArea(resultContent);
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
