package domain;

import domain.score.Pin;

public class TestStrategy implements PlayStrategy {
    @Override
    public Pin play() {
        return new Pin(5);
    }
}
