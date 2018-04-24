package view;

import domain.Player;
import state.State;

import java.util.List;

public class ResultView2 {
    static final private String NAME_TITLE = "| NAME |";
    static final private String EMPTY_SCORE = "      |";
    static final private int MAX_FRAME = 10;

//    public static void printFrames(List<Frame> frames, Frame frame, String name) {
//        printHeader();
//        printSymbol(frames, frame, name);
//        printScore(frames);
//    }

    private static void printHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append(NAME_TITLE);
        for (int index = 0; index < 10; index++) {
            sb.append(String.format("  %02d  |", index + 1));
        }
        System.out.println(sb.toString());
    }

    private static void printSymbol(Player player, State currentState) {
        StringBuilder sb = new StringBuilder();
        int offset = 0; // 현재 상태 출력시 공백 조절
        sb.append(String.format("| %3s  |", player.printName()));
        for (int index = 0; index < player.getFinishedFrame(); index++) {
            sb.append(String.format(" %3s  |", player.printFramesState(index)));
        }
        if (!currentState.isEnd()) {
            sb.append(String.format(" %3s  |", currentState.printState()));
            offset = -1;
        }
        for (int index = 0; index < MAX_FRAME - player.getFinishedFrame() + offset; index++) {
            sb.append(EMPTY_SCORE);
        }
        offset = 0;
        System.out.println(sb.toString());
    }

    public static void printScore(Player player) {
        int beforeScore = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("|" + EMPTY_SCORE);
        for (int index = 0; index < player.getFinishedFrame(); index++) {
            beforeScore = player.printFramesScore(index, beforeScore);
            sb.append(String.format(" %-3s  |", beforeScore));
        }
        for (int index = 0; index < MAX_FRAME - player.getFinishedFrame(); index++) {
            sb.append(EMPTY_SCORE);
        }
        System.out.println(sb.toString());
//        System.out.println(player.printFramesScore());
    }

    public static void printEmptyScore() {
        printHeader();
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < 10; index++) {
            sb.append(EMPTY_SCORE);
        }
        System.out.println(sb.toString());
    }

    public static void printScoreBoard(List<Player> players, State currentState) {
        for (Player player : players) {
            printHeader();
            printSymbol(player, currentState);
            printScore(player);
        }
    }
}