package bowling;

import bowling.domain.Game;
import bowling.domain.IllegalPlayerNameException;
import bowling.domain.Player;
import bowling.view.ConsoleInputView;
import bowling.view.ConsoleOutputView;

public class ConsoleMain {
    public static void main(String[] args) {
        Player player = setPlayer();
        Game game = new Game();

        while (!game.isEnd()) {
            game.roll(ConsoleInputView.askKnockDownPins(game.getCurrentFrame()));
            ConsoleOutputView.print(player, game.getFrames());
        }
    }

    private static Player setPlayer() {
        Player player = null;

        do {
            try {
                player = new Player(ConsoleInputView.askPlayerName());
            } catch (IllegalPlayerNameException e) {
                ConsoleOutputView.showErrorMessage(e.getMessage());
            }
        } while (player == null || !player.hasCorrectName());

        return player;
    }
}
