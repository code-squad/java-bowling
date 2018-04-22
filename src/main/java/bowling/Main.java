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
            String name = UserPrompt.promptUserForName(); //TODO: 유효성 검사
            return name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserName();
        }
    }

    private static void startBowl(Player player) {
        while (!player.isDone()) {
            int pins = UserPrompt.promptUserForBowl(player.getCurrentFrameNumber()); //TODO: 유효성 검사 (프레임 안에서)
            player.bowl(pins);
            ResultView.printScoreBoard(player);
        }
    }
}