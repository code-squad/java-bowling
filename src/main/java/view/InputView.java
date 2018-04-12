package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int getNumber() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return getNumber();
        }
    }

    public static String getName() {
        try {
            return scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            return getName();
        }
    }

}
