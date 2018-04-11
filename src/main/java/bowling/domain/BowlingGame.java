package bowling.domain;

import java.util.List;

public class BowlingGame {
    private Frames frames;

    public BowlingGame() {
        this.frames = new Frames();
    }

    public void updateFrames(int frameNumber, int pinsKnocked) {
        frames.updateFrame(frameNumber, pinsKnocked);
    }
}
