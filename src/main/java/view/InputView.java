package view;

import domain.Player;

import java.util.Scanner;

public class InputView {

    public static Player getPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("플레이어 이름은(3 english letters) : ");

        String name = scanner.nextLine();
        return new Player(name, new ConsolePlayStrategy(), new ConsoleScoreBoard());
    }

}
