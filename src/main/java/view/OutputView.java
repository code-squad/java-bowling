package view;

import domain.Player;
import domain.frame.Frames;
import domain.frame.result.score.FrameScore;

public class OutputView {

    public static void printResult(Player player) {
        System.out.println(getTopMessage() + getResultMessage(player) + getResultScore(player));
    }

    private static String getTopMessage() {
        return "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n";
    }

    private static String getResultMessage(Player player) {
        StringBuilder builder = new StringBuilder();
        builder.append("|").append(fillArea(player.getName())).append("|");
        for (int frameNum = 1; frameNum <= Frames.LIMIT_NUM; frameNum++) {
            String message = player.getFrameResultMessage(frameNum);
            appendResultMessage(builder, message);
        }
        builder.append("\n");
        return builder.toString();
    }

    private static void appendResultMessage(StringBuilder builder, String message) {
        if (message == null) {
            builder.append(fillArea("")).append("|");
            return;
        }
        builder.append(fillArea(message)).append("|");
    }

    private static String getResultScore(Player player) {
        StringBuilder builder = new StringBuilder();
        builder.append("|").append(fillArea("")).append("|");
        for (int frameNum = 1; frameNum <= Frames.LIMIT_NUM; frameNum++) {
            FrameScore score = player.getFrameResultScore(frameNum);
            appendResultScore(builder, score);
        }
        return builder.toString();
    }

    private static void appendResultScore(StringBuilder builder, FrameScore score) {
        if (score == null) {
            builder.append(fillArea("")).append("|");
            return;
        }
        builder.append(fillArea(String.valueOf(score.getScore()))).append("|");
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
