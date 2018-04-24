package view;

import domain.Frame;

import java.util.List;

public class ResultView {
    static final private String NAME_TITLE = "| NAME |";
    static final private String EMPTY_SCORE = "      |";
    static final private int MAX_FRAME = 10;

    public static void printFrames(List<Frame> frames, Frame frame, String name) {
        printHeader();
        printSymbol(frames, frame, name);
        printScore(frames);
    }

    private static void printSymbol(List<Frame> frames, Frame frame, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("| %3s  |", name));
        for (int index = 0; index < frames.size(); index++) {
           sb.append(String.format(" %-5s|", frames.get(index).printState()));
        }
        sb.append(String.format(" %-5s|", frame.printState()));
        for (int index = 0; index < MAX_FRAME - frames.size() - 1; index++) {
            sb.append(EMPTY_SCORE);
        }
        System.out.println(sb.toString());
    }

    private static void printHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append(NAME_TITLE);
        for (int index = 0; index < 10; index++) {
            sb.append(String.format("  %02d  |", index + 1));
        }
        System.out.println(sb.toString());
    }

    public static void printScore(List<Frame> frames) {
        StringBuilder sb = new StringBuilder();
        sb.append("|"+EMPTY_SCORE);
        for (int index = 0; index < frames.size(); index++) {
//            sb.append(String.format(" %-3s  |", frames.get(index).printScore()));
        }
        for (int index = 0; index < MAX_FRAME - frames.size(); index++) {
            sb.append(EMPTY_SCORE);
        }
        System.out.println(sb.toString());
    }


    public static void printEmptyScore() {
        printHeader();
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < 10; index++) {
            sb.append(EMPTY_SCORE);
        }
        System.out.println(sb.toString());
    }
}
