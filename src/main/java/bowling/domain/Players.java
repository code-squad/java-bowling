package bowling.domain;

import bowling.dto.PlayerResult;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        inputValidationCheck(players);

        this.players = players;
    }

    private void inputValidationCheck(List<Player> players) {
        if(players == null || players.isEmpty())
            throw new IllegalArgumentException("Invalid input for Players");
    }

    public boolean isGameEnd() {
        return players.stream()
                .anyMatch(Player::isEnd);
    }

    public Player rotate(Player currentPlayer) {
        currentPlayer.frameNoUpdate();

        int idx = players.indexOf(currentPlayer) + 1 % players.size();

        return players.get(idx);
    }

    public List<PlayerResult> getPlayerResults() {
        return players.stream()
                .map(Player::getPlayerResult)
                .collect(Collectors.toList());
    }
}
