package bowling.io;

import bowling.domain.Name;

import java.util.Scanner;

public class InputView {
    public static Name playerName() {
        System.out.println("플레이어 이름은(3 english letters)?:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while(!isName(name)) {
            System.out.println("플레이어 이름은(3 english letters)?:");
            name = scanner.nextLine();
        }
        return new Name(name);
    }

    public static boolean isName(String name) {
        return name.matches("[a-zA-Z]{1,3}");
    }
}
