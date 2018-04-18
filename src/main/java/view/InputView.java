package view;

import java.util.Scanner;

public class InputView {
    public static String getUserName(Scanner scanner) {
        System.out.print("\n플레이어 이름은(3 english letters)?: ");
        return scanner.nextLine();
    }

    public static int getThrowing(Scanner scanner, int no) {
        System.out.print("\n"+no + "프레임 투구 : ");
        return scanner.nextInt();
    }
}
