import domain.Player;
import domain.frame.BowlingGame;
import view.ConsoleScoreBoard;

import static view.InputView.getPlayer;

public class Main {
    public static void main(String[] args) {
        Player player = getPlayer();

        BowlingGame game = new BowlingGame(player, new ConsoleScoreBoard());

        game.playBowling();
    }
}
