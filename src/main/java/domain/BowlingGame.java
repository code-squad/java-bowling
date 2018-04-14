package domain;

import java.util.List;

public class BowlingGame {
    List<Frame> frames;

    BowlingGame(String name) {

    }

    public Frame createNormalFrame() {
        return new NormalFrame();
    }

    public Frame createLastFrame() {
        return new LastFrame();
    }

    public void playing() {

    }
}
