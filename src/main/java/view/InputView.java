package view;

import domain.player.Player;
import domain.player.PlayerName;
import domain.player.Players;
import utils.InputUtils;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int getPlayerNum() {
        System.out.println("몇명 플레이 하나요?");
        try {
            return InputUtils.convertToNumber(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerNum();
        }
    }

    public static Players getPlayers(int playerNum) {
        try {
            return new Players(buildPlayers(playerNum));
        } catch (IllegalArgumentException e) {
            return getPlayers(playerNum);
        }
    }

    private static List<Player> buildPlayers(int playerNum) {
        List<Player> players = new ArrayList<>();
        for (int order = 1; order <= playerNum; order++) {
            players.add(getPlayer(order));
        }
        return players;
    }

    private static Player getPlayer(int order) {
        System.out.println("플레이어(" + order + ")의 이름은(" + PlayerName.LENGTH + " english letters)?");
        try {
            return new Player(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer(order);
        }
    }

    public static int getPinNum(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + " 차례");
        try {
            return InputUtils.convertToNumber(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPinNum(currentPlayer);
        }
    }
}
