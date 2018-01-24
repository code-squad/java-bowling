package bowling.domain;

import java.util.List;

public class BowlingGame {
    private Players players;
    private Player currentPlayer;

    public BowlingGame(List<Player> players) {
        this.players = new Players(players);
        this.currentPlayer = players.get(0);
    }

    public void rollBowlingBall(Pin fellPin) {
        getCurrentPlayer().rollBowlingBall(fellPin);
        updatePlayerQueue();
    }

    public boolean isGameEnd() {
        return players.isGameEnd();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void updatePlayerQueue() {
        if(getCurrentPlayer().isCurrentFrameEnd())
            currentPlayer = players.rotate(currentPlayer);
    }

    public Players getPlayers() {
        return players;
    }

}
