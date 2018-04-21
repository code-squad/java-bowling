package domain;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private static final int FIRST = 1;
    private List<Player> players;

    public BowlingGame(List<String> names) {
        createPlayer(names);
    }

    public List<Player> createPlayer(List<String> names) {
        players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    public Frame createFirstFrame() {
        return new NormalFrame(FIRST);
    }

    public
}
