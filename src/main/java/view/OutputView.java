package view;

import domain.frame.Frame;
import domain.frame.result.Board;
import domain.frame.result.Boards;
import domain.player.Player;
import domain.player.Players;

import java.util.List;

public class OutputView {

    public static void printBoards(Boards boards) {
        System.out.println(getTopMessage() + getBoardMessage(boards));
    }

    private static String getTopMessage() {
        StringBuilder builder = new StringBuilder("|" + fillArea("NAME") + "|");
        for (int frameNum = 1; frameNum <= Board.LIMIT; frameNum++) {
            builder.append(fillArea(convertFrameNum(frameNum)));
            builder.append("|");
        }
        builder.append("\n");
        return builder.toString();
    }

    private static String convertFrameNum(int frameNum) {
        if (frameNum == Board.LIMIT) {
            return String.valueOf(frameNum);
        }
        return String.valueOf("0" + frameNum);
    }

    private static String getBoardMessage(Boards boards) {
        List<String> playerNameList = boards.getPlayerNameList();
        StringBuilder builder = new StringBuilder();
        for (String name : playerNameList) {
            builder.append(getResultMessage(boards, name));
            builder.append(getResultScore(boards, name));
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String getResultMessage(Boards boards, String name) {
        List<String> resultMessages = boards.getResultMessage(name);
        StringBuilder builder = new StringBuilder("|" + fillArea(name) + "|");
        for (String resultMessage : resultMessages) {
            builder.append(fillArea(resultMessage));
            builder.append("|");
        }
        fillEmptyArea(builder, Board.LIMIT - resultMessages.size());
        builder.append("\n");
        return builder.toString();
    }

    private static String getResultScore(Boards boards, String name) {
        List<Integer> resultScores = boards.getResultScore(name);
        StringBuilder builder = new StringBuilder("|" + fillArea("") + "|");
        for (Integer resultScore : resultScores) {
            builder.append(fillArea(convertScore(resultScore)));
            builder.append("|");
        }
        fillEmptyArea(builder, Board.LIMIT - resultScores.size());
        return builder.toString();
    }

    private static void fillEmptyArea(StringBuilder builder, int emptySize) {
        for (int i = 0; i < emptySize; i++) {
            builder.append(fillArea(""));
            builder.append("|");
        }
    }

    private static String convertScore(int score) {
        if (score == Frame.CANNOT_CALC_SCORE_STATE) {
            return "";
        }
        return String.valueOf(score);
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
