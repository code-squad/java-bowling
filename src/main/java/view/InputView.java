package view;

import domain.Player;
import domain.PlayerName;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Player getPlayer() {
        System.out.println("플레이어 이름은 (" + PlayerName.LENGTH + " english letters)?");
        try {
            return new Player(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }
}
