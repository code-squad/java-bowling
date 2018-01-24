package domain;

import domain.score.Pin;

public class TestStrategy implements PlayStrategy {
    @Override
    public Pin play(int frameNo) {
        return new Pin(5);
    }
}
