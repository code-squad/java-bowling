package view;

import domain.Player;
import domain.frame.result.FrameResults;

import java.util.Arrays;

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
            if (isLastFrame(results, frameIdx)) {
                builder.append("|");
            }
        }
        return builder.toString();
    }

    private static boolean isLastFrame(FrameResults results, int frameIdx) {
        return results.getMaxSaveSize() - 1 == frameIdx;
    }

    private static String buildFrameResultMessage(FrameResults results, int frameIdx) {
        String resultContent = results.getFrameResultMessage(frameIdx);
        if (resultContent == null) {
            return fillArea("");
        }
        return fillArea(resultContent);
    }








    // TODO : 고치자 간결하게
    private static String fillArea(String content) {
        char[] area = new char[6];
        Arrays.fill(area, ' ');
        char[] contentArr = content.toCharArray();
        int startIdx = getFillStartIdx(content);
        for (int i = startIdx, j = 0; i < area.length && j < contentArr.length; i++, j++) {
            area[i] = contentArr[j];
        }
        return String.valueOf(area);
    }

    private static int getFillStartIdx(String content) {
        int defaultStartIdx = 2;
        if (content.length() > 4) {
            return defaultStartIdx - 1;
        }
        return defaultStartIdx;
    }
}
