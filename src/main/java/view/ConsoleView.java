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

    public static void printScoreBoard(String name, Frame head) {
        // Upper Line
        StringBuilder builder = new StringBuilder();
        builder.append("| NAME |  ");
        builder.append(IntStream.range(1, 11)
                .mapToObj(i -> (i / 10) + "" + (i % 10))
                .collect(Collectors
                        .joining("  |  ")));
        builder.append("  |");
        System.out.println(builder.toString());

        // Lower Line
        builder = new StringBuilder();

        builder.append("|  ")
                .append(name)
                .append(" |  ");

        while(head != null) {
            builder.append(head.toString());
            builder.append(" |  ");
            head = head.getNextFrame();
        }

        System.out.println(builder.toString());
    }

    public static int inputBowl(int frameNumber){
        System.out.println(frameNumber + "프레임 투구 : ");
        return Integer.parseInt(scanner.next());
    }

}
