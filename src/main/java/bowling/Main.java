package bowling;

import bowling.domain.Players;
import bowling.view.ResultView;
import bowling.view.UserPrompt;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> playerNames = getUserName();
        Players players = new Players(playerNames);
        startBowl(players);
    }

    private static List<String> getUserName() {
        return UserPrompt.promptUserForNames();
    }

    private static void startBowl(Players players) {
        while (!players.allPlayersAreDone()) {
            try {
                int pins = UserPrompt.promptUserForBowl(players.getPlayerName());
                players.bowl(pins);
                ResultView.printScoreBoard(players);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}