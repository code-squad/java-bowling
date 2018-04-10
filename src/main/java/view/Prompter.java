package view;

import java.util.Scanner;

public class Prompter {

    public static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String promptForPlayerNames() {
        System.out.print("플레이어 이름 (3 english letters)?: ");
        return takeInput();
    }

    public static String promptForThrowScore(int frameNumber) {
        System.out.printf("%d프레임 투구: ", frameNumber);
        return takeInput();
    }

    public static String promptForBonusScore() {
        System.out.println("보너스 투구: ");
        return takeInput();
    }
}
