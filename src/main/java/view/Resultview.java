package view;

import domain.NormalFrame;

import java.util.List;

import static domain.Status.*;

public class Resultview {
    static final private String PIPE = "|";
    static final private String NAME_TITLE = "| NAME |";
    static final private int MAX_FRAME = 10;

    public static void printResult(String name, List<NormalFrame> frames) {
        printScoreTitle();
        printScore(name, frames);
    }

    private static void printScore(String name, List<NormalFrame> frames) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PIPE + " %-4s " + PIPE, name));
        for (NormalFrame normalFrame : frames) {
            if (normalFrame.isStatus(STRIKE)) {
                sb.append(String.format("  %-3s |", getIndicator(STRIKE)));
                continue;
            }
//            String first = String.valueOf(normalFrame.getFirst());
//            String second = String.valueOf(normalFrame.getSecond());
//            if (isGutter(first)) {
//                first = getIndicator(GUTTER);
//            }
//            if (isGutter(second)) {
//                second = getIndicator(GUTTER);
//            }
            if (normalFrame.isStatus(SPARE)) {
                sb.append(String.format("  %-3s |", first + PIPE + getIndicator(SPARE)));
                continue;
            }
            if (normalFrame.isStatus(OPEN)) {
                sb.append(String.format("  %-3s |", first + PIPE + second));
            }
        }
        for (int index = 1; index < MAX_FRAME - frames.size(); index++) {
            sb.append(String.format("  %-3s |", ""));
        }
        System.out.println(sb.toString());
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
