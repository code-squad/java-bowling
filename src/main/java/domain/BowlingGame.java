package domain;

import state.State;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private static final int FIRST = 1;
    private List<Player> players;

    public List<Player> createPlayer(List<String> names) {
        players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    public Pins createPins(int falledPins) {
        return new Pins(falledPins);
    }

    public State bowl(Player player, int falledPins) {
        return player.bowl(createPins(falledPins));
    }

    public boolean isEndFrame(Player player) {
        // 다수 고려하지 않음, 우선 한 명만.
        return player.isEnd();
    }

    public Frame nextFrame(Player player) {
        return player.nextFrame();
    }
}
