package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private List<Frame> frames;

    public Frames() {
        this.frames = initializeFrames();
    }

    public List<Frame> initializeFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        return frames;
    }

    public void updateFrame(int frameNumber, int pinsKnocked) {
        frames.get(frameNumber).updateScore(pinsKnocked);
    }
}
