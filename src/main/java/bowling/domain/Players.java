package bowling.domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        inputValidationCheck(players);

        this.players = players;
    }

    private void inputValidationCheck(List<Player> players) {
        if(players == null)
            throw new IllegalArgumentException("Invalid input for Players");
    }

    public boolean checkIsEnd() {
        return players.stream()
                .anyMatch(Player::isEnd);
    }

    public List<Player> getPlayersAsList() {
        return Collections.unmodifiableList(players);
    }
}
