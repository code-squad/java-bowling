package domain.frame.result;

import domain.player.Player;

import java.util.Map;

public class Boards {
    private Map<Player, Board> boards;

    public Boards(Map<Player, Board> boards) {
        this.boards = boards;
    }

    /*private <T> List<T> makeWithPlayer(Function<Player, T> mapper) {
        return players.stream().map(mapper).collect(toList());
        return null;
    }*/
}
