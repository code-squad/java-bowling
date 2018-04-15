package bowling.view;

import bowling.domain.Player;

public class BowlingGame {
    private final Player player;

    public BowlingGame(Player player) {
        this.player = player;
    }

    public void startGame() {
        while (!player.isLastFrame()) {
            int pinsKnocked = Prompter.promptForThrow(player.getPreviousFrameNumber());
            player.throwBall(pinsKnocked);
        }
    }

    public Player getPlayer() {
        return player;
    }
}