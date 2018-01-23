package view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleView {
    private static Scanner scanner = new Scanner(System.in);

    public static String askName() {
        System.out.println("플레이어 이름은(3 english letters)?: ");
        return scanner.next();
    }

    public static int askPinCount(int frameNumber) {
        System.out.println(frameNumber + "프레임 투구 : ");
        return Integer.parseInt(scanner.next());
    }

    public static void printScoreBoard(String name, List<String> statusStrings, List<String> scoreStrings) {
        printHeader();
        printFrameStatus(name, statusStrings);
        printScoreReducer(scoreStrings);
    }

    private static void printHeader() {
        StringBuilder builder = new StringBuilder();
        builder.append("| NAME |   ");
        builder.append(IntStream
                .range(1, 11)
                .mapToObj(i -> (i / 10) + "" + (i % 10))
                .collect(Collectors
                        .joining("   |   ")));
        builder.append("   |");
        System.out.println(builder.toString());
    }

    private static void printFrameStatus(String name, List<String> statusStrings) {
        StringBuilder builder = new StringBuilder();
        builder.append("|  ")
                .append(name)
                .append(" |");

        for (String statusString : statusStrings) {
            int len = statusString.length();

            builder.append("   ");
            builder.append(statusString);
            builder.append("      ".substring(0, 6 - len - 1));
            builder.append("|");
        }

        System.out.println(builder.toString());
    }

    private static void printScoreReducer(List<String> scoreStrings) {
        StringBuilder builder = new StringBuilder();
        builder.append("|      |");

        for (String scoreString : scoreStrings) {
            builder.append("   ");
            builder.append(scoreString);
            builder.append("      ".substring(0, 6 - String.valueOf(scoreString).length() - 1));
            builder.append("|");
        }

        System.out.println(builder.toString());
    }

}
