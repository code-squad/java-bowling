package bowling;

import bowling.domain.Player;
import bowling.domain.Util.Parser;
import bowling.view.BowlingGame;
import bowling.view.ScoreBoard;

import static bowling.view.Prompter.*;

public class Main {
    public static void main(String[] args) {
        Player player = getPlayer();
        BowlingGame game = new BowlingGame(player);

        game.startGame();
        ScoreBoard scoreBoard = new ScoreBoard(game);
    }

    private static Player getPlayer() {
        try {
            String playerName = Parser.parseName(promptForName());
            return new Player(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }
}