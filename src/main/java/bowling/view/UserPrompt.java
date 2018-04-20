package bowling.view;

import java.util.Scanner;

public class UserPrompt {

    public static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String promptUserForName() {
        return takeInput();
    }

    public static int promptUserForBowl() {
        String input = takeInput();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return promptUserForBowl();
        }
    }
}
