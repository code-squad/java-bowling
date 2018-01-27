package bowling.domain;

import bowling.dto.Board;

import java.util.List;

public class BowlingGame {
    private Players players;
    private Player currentPlayer;

    public BowlingGame(List<Player> players) {
        this.players = new Players(players);
        this.currentPlayer = players.get(0);
    }

    public void rollBowlingBall(int fellPin) {
        currentPlayer.rollBowlingBall(fellPin);
        updatePlayerQueue();
    }

    public boolean isGameEnd() {
        return players.isGameEnd();
    }

    private void updatePlayerQueue() {
        if(currentPlayer.isCurrentFrameEnd())
            currentPlayer = players.rotate(currentPlayer);
    }

    public Board createBoard() {
        return new Board(currentPlayer.createPlayerInfo(), players.getPlayerResults());
    }
}
