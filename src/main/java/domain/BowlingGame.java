package domain;

import state.State;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private static final int FIRST = 1;
    private List<Player> players;

    public BowlingGame() {
    }

    public List<Player> createPlayer(List<String> names) {
        players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    public State bowl(int falledPins) {
        return players.get(0).bowl(falledPins);
    }

    public boolean isEndFrame() {
        // 다수 고려하지 않음, 우선 한 명만.
        return players.get(0).isEnd();
    }

    public Frame nextFrame() {
        return players.get(0).nextFrame();
    }
}
