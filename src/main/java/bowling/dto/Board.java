package bowling.dto;

import bowling.domain.Player;

import java.util.List;

public class Board {
    private Player currentPlayer;
    private List<PlayerResult> playerResults;

    public Board(Player currentPlayer, List<PlayerResult> playerResults) {
        if(currentPlayer == null || playerResults == null || playerResults.isEmpty())
            throw new IllegalArgumentException("input is not enough");

        this.currentPlayer = currentPlayer;
        this.playerResults = playerResults;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public List<PlayerResult> getPlayerResults() {
        return playerResults;
    }
}
