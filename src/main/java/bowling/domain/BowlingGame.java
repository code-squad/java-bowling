package bowling.domain;

import java.util.List;

public class BowlingGame {
    private Players players;
    private PlayerQueue playerQueue;

    public BowlingGame(List<Player> players) {
        this.players = new Players(players);
        this.playerQueue = new PlayerQueue(players);
    }

    public void rollBowlingBall(Pin fellPin) {
        getCurrentPlayer().rollBowlingBall(fellPin);
        updatePlayerQueue();
    }

    public boolean isGameEnd() {
        return players.isGameEnd();
    }

    public Player getCurrentPlayer() {
        return playerQueue.getCurrentPlayer();
    }

    private void updatePlayerQueue() {
        if(getCurrentPlayer().isCurrentFrameEnd())
            playerQueue.rotate();
    }

    public Players getPlayers() {
        return players;
    }
}
