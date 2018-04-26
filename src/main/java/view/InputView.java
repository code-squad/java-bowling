package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> getUserName(Scanner scanner, int count) {
        scanner.reset();
        List<String> users = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            System.out.print("플레이어 " + (index + 1) + "의 이름은(3 english letters)?: ");
            String name = scanner.nextLine();
            users.add(name);
        }
        return users;
    }

    public static int getThrowing(Scanner scanner, String name) {
        System.out.print("\n" + name + "'s trun : ");
        return scanner.nextInt();
    }

    public static int getUserCount(Scanner scanner) {
        System.out.print("How many people? ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            return getUserCount(scanner);
        }
    }
}
