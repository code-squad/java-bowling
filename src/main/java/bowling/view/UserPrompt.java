package bowling.view;

import java.util.Scanner;

public class UserPrompt {

    private static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String promptUserForName() {
        System.out.print("이름을 입력해 주세요: ");
        return takeInput();
    }

    public static int promptUserForBowl(int frameNumber) {
        try {
            System.out.printf("%d프레임 투구: ", frameNumber);
            String input = takeInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return promptUserForBowl(frameNumber);
        }
    }
}