package input;

import java.util.Scanner;

public class Input {
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public Integer inputNum() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
