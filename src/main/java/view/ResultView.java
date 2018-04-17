package view;

import domain.Frame;

import java.util.List;

public class ResultView {
    static final private String PIPE = "|";
    static final private String NAME_TITLE = "| NAME |";
    static final private int MAX_FRAME = 10;


    public static void printFrames(List<Frame> frames) {
        printScoreTitle();
        System.out.print("| htw  |");
        for (int index = 0; index < frames.size(); index++) {
            System.out.print(String.format("  %-3s |", frames.get(index).printState()));
        }
        for (int index = 0; index < MAX_FRAME - frames.size(); index++) {
            System.out.print("      |");
        }
    }

    private static void printScoreTitle() {
        StringBuilder sb = new StringBuilder();
        sb.append(NAME_TITLE);
        for (int index = 0; index < 10; index++) {
            sb.append(String.format("  %02d  |", index + 1));
        }
        System.out.println(sb.toString());
    }
}
