package bowling.domain.frame;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private final List<Frame> frames;

    public Frames() {
        List<Frame> frames = new ArrayList<>();
        for (int frameNumber = 0; frameNumber < 8; frameNumber++) {
            frames.add(new NormalFrame(frameNumber));
        }
        frames.add(new LastFrame());
        this.frames = frames;
    }

    public Frame getNext(int frameNumber) {
        return frames.get(frameNumber + 1);
    }

    public Frame getNextNext(int frameNumber) {
        return frames.get(frameNumber + 2);
    }

    public void bowl(int pins) {

    }

    public void calculateFrameScores() {
        for (Frame frame : frames) {

        }
    }
}
