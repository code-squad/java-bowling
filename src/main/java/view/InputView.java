package view;

import java.util.Scanner;

public class InputView {

    public static String getUserName(Scanner scanner) {
        return scanner.nextLine();
    }

    public static int getThrowing(Scanner scanner) {
        return scanner.nextInt();
    }
}
