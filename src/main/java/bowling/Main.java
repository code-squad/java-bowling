package bowling;

import bowling.domain.Player;
import bowling.view.ResultView;
import bowling.view.UserPrompt;

public class Main {
    public static void main(String[] args) {
        String name = getUserName();
        Player player = new Player(name);
        startBowl(player);
    }

    private static String getUserName() {
        try {
            return UserPrompt.promptUserForName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserName();
        }
    }

    private static void startBowl(Player player) {
        while (!player.isDone()) {
            try {
                int pins = UserPrompt.promptUserForBowl(player.getCurrentFrameNumber());
                player.bowl(pins);
                ResultView.printScoreBoard(player);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}