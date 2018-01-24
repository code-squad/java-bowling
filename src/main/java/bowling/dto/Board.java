package bowling.dto;

import bowling.domain.Player;

import java.util.List;

public class Board {
    private CurrentPlayerInfo currentPlayerInfo;
    private List<PlayerResult> playerResults;

    public Board(CurrentPlayerInfo currentPlayerInfo, List<PlayerResult> playerResults) {
        if(currentPlayerInfo == null || playerResults == null || playerResults.isEmpty())
            throw new IllegalArgumentException("input is not enough");

        this.currentPlayerInfo = currentPlayerInfo;
        this.playerResults = playerResults;
    }

    public CurrentPlayerInfo getCurrentPlayerInfo() {
        return currentPlayerInfo;
    }

    public List<PlayerResult> getPlayerResults() {
        return playerResults;
    }
}
