package bowling.domain;

import java.util.List;

public class BowlingGame {
    private static final String TOP_MESSAGE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |\n";

    private Players players;
    private PlayerQueue playerQueue;

    public BowlingGame(List<Player> players) {
        inputValidationCheck(players);

        this.players = new Players(players);
        this.playerQueue = new PlayerQueue(players);
    }

    private void inputValidationCheck(List<Player> players) {
        if(players == null)
            throw new IllegalArgumentException("Players not valid");
    }

    public Player getCurrentPlayer() {
        return playerQueue.getCurrentPlayer();
    }

    public Player getPreviousPlayer() {
        return playerQueue.getPreviousPlayer();
    }

    public void rollBowlingBall(Pin fellPin) {
        getCurrentPlayer().rollBowlingBall(fellPin);
        updatePlayerQueue();
    }

    public void updatePlayerQueue() {
        if(getCurrentPlayer().isCurrentFrameEnd())
            playerQueue.rotate();
    }
}
