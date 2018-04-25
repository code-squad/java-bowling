package bowling.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPrompt {
    private static final int ACCEPTED_LENGTH = 3;

    private static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int takeNumberOfPlayers() {
        try {
            String input = takeInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다");
            return takeNumberOfPlayers();
        }
    }

    private static String validateName(String name) {
        if (name.length() != ACCEPTED_LENGTH) {
            throw new IllegalArgumentException("입력된 이름이 3자가 아닙니다.");
        }
        return name;
    }

    private static String promptUserForName(int number) {
        try {
            System.out.printf("플레이어 %d의 이름은?(3 english letters): ", number);
            return validateName(takeInput());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return promptUserForName(number);
        }
    }

    public static List<String> promptUserForNames() {
        System.out.println("How many people? ");
        int numberOfPeople = takeNumberOfPlayers();
        List<String> playerNames = new ArrayList<>();
        for (int number = 0; number < numberOfPeople; number++) {
            String name = promptUserForName(number);
            playerNames.add(name);
        }
        return playerNames;
    }

    public static int promptUserForBowl(String name) {
        try {
            System.out.printf("%s's turn: ", name);
            String input = takeInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return promptUserForBowl(name);
        }
    }
}