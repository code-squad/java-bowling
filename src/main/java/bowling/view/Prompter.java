package bowling.view;

import java.util.Scanner;

public class Prompter {

    private static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String promptForName() {
        System.out.print("플레이어 이름은(3 english letters)?: ");
        return takeInput();
    }

    public static String promptForThrow(int frameNumber) {
        System.out.printf("%d 프레임 투구: ", frameNumber);
        return takeInput();
    }
}
