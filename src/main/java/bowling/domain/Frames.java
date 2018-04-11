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

    public void updateFrame(int throwCount, int pinsKnocked) {
        int frameNumber = throwCount / 2;
        if (frameNumber < 19) {
            frames.get(throwCount).updateScore(pinsKnocked);
        }
        frames.get(19).updateScore(pinsKnocked);
    }
}
