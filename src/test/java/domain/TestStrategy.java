package domain;

import domain.score.Score;

public class TestStrategy implements PlayStrategy {
    @Override
    public Score play(int frameNo) {
        return new Score(5);
    }
}
