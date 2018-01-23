package bowling.domain;

import java.util.List;

public class BowlingGame {
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

    public void rollBowlingBall(Pin fellPin) {
        getCurrentPlayer().rollBowlingBall(fellPin);
        updatePlayerQueue();
    }

    public void updatePlayerQueue() {
        if(getCurrentPlayer().isCurrentFrameEnd())
            playerQueue.rotate();
    }

    public boolean isEnd() {
        return players.checkIsEnd();
    }

    public Players getPlayers() {
        return players;
    }
}
