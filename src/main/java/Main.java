import domain.Player;
import domain.frame.BowlingGame;
import view.ConsoleScoreBoard;

import static view.InputView.getPlayer;

public class Main {
    public static void main(String[] args) {
        Player player = getPlayer();

        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard();
        BowlingGame game = new BowlingGame(player, scoreBoard);

        scoreBoard.printGameResult(game);
        game.playBowling();
    }
}
