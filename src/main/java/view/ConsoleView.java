package view;

import model.frame.Frame;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleView {
    private static Scanner scanner = new Scanner(System.in);

    public static String askName() {
        System.out.println("플레이어 이름은(3 english letters)?: ");
        return scanner.next();
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

    private static void printFrameStatus(String name, Frame head) {
        StringBuilder builder = new StringBuilder();
        builder.append("|  ")
                .append(name)
                .append(" |");

        while (head != null) {
            String str = head.toString();
            int len = str.length();

            builder.append("   " + str + "      ".substring(0, 6 - len - 1));
            builder.append("|");
            head = head.getNextFrame();
        }
        System.out.println(builder.toString());
    }

    private static void printScoreReducer(Frame head) {
        StringBuilder builder = new StringBuilder();
        builder.append("|      |");

        int scoreSum = 0;
        boolean canGetScore = true;
        while (head != null) {
            String str = "        ";
            if (head.getScore() == -1) {
                canGetScore = false;
            }

            if (canGetScore && head.isFinished()) {
                scoreSum += head.getScore();
                str = "   " + scoreSum + "      ".substring(0, 6 - String.valueOf(scoreSum).length() - 1);
            }
            builder.append(str);
            builder.append("|");
            head = head.getNextFrame();
        }
        System.out.println(builder.toString());
    }

    public static void printScoreBoard(String name, Frame head) {
        printHeader();
        printFrameStatus(name, head);
        printScoreReducer(head);
    }

    public static int inputBowl(int frameNumber) {
        System.out.println(frameNumber + "프레임 투구 : ");
        return Integer.parseInt(scanner.next());
    }

}
