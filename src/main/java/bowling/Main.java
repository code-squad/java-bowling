package bowling;

import bowling.domain.BowlingGame;
import bowling.domain.Player;
import bowling.domain.ScoreBoard;
import bowling.domain.Validator;

import static bowling.view.Prompter.*;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("JAE");
        ScoreBoard scoreBoard = new ScoreBoard(player);
        BowlingGame game = new BowlingGame(scoreBoard);

        game.startGame();
    }

    private static Player getPlayer() {
        try {
            String playerName = promptForName();
            Validator.validateName(playerName);
            return new Player(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }
}