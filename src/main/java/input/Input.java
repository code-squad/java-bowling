package input;

import java.util.Scanner;

public class Input {
    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public Integer inputNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("투구를 하시오 ");
        return scanner.nextInt();
    }
}
