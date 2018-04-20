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
            String name = UserPrompt.promptUserForName();
            return name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserName();
        }
    }

    private static void bowl(Player player) {
        while (!player.isDone()) {
            int pins = UserPrompt.promptUserForBowl();
            player.bowl(pins);
            System.out.println(player.convertToPrintable());
        }
    }
}
