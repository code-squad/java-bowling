package bowling;

import bowling.domain.Player;
import bowling.view.UserPrompt;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Jae");
        bowl(player);
    }

    private static String getUserName() {
        try {
            String name = UserPrompt.promptUserForName(); //TODO: 유효성 검사
            return name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserName();
        }
    }

    private static void bowl(Player player) {
        while (!player.isDone()) {
            int pins = UserPrompt.promptUserForBowl(); //TODO: 유효성 검사 (프레임 안에서)
            player.bowl(pins);
            System.out.println(player.convertToPrintable());
        }
    }
}