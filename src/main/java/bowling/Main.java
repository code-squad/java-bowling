package bowling;

import bowling.domain.Player;
import bowling.domain.Util.Parser;
import bowling.view.ScoreBoard;

import static bowling.view.Prompter.*;

public class Main {
    public static void main(String[] args) {
        Player player = getPlayer();
        startGame(player);
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

    private static void startGame(Player player) {
        while(!player.isLastFrame()) {
            int pinsKnocked = promptForThrow(player.getPreviousFrameNumber());
            player.throwBall(pinsKnocked);
            ScoreBoard.printScoreBoard(player);
        }
    }
}