package domain;

import domain.score.Pin;

public class Player {

    private final PlayStrategy strategy;

    private final String playerName;

    public Player(String playerName, PlayStrategy strategy) {
        if (strategy == null || playerName.length() != 3) {
            throw new IllegalArgumentException();
        }
        this.playerName = playerName;
        this.strategy = strategy;
    }

    public Pin play(int frameNo) {
        return strategy.play(frameNo);
    }

    @Override
    public String toString() {
        return playerName;
    }
}
