package bowling.view;

import bowling.domain.Formatter;
import bowling.domain.Validator;

import java.util.Scanner;

public class Prompter {

    private static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String promptForName() {
        try {
            System.out.print("플레이어 이름은(3 english letters)?: ");
            return Validator.validateName(takeInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return promptForName();
        }
    }

    public static int promptForThrow(int frameNumber) {
        try {
            System.out.printf("%d 프레임 투구: ", frameNumber + 1);
            return Formatter.convertToInt(takeInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return promptForThrow(frameNumber);
        }
    }
}
