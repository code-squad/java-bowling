package bowling.domain.frame;

import java.util.ArrayList;
import java.util.List;

import static bowling.domain.Utils.Formatter.formatFrame;

public class Frames {
    private List<Frame> frames;

    public Frames() {
        this.frames = initializeFrames();
    }

    private List<Frame> initializeFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        return frames;
    }

    public boolean updateFrame(int frameNumber, int pinsKnocked) {
        return frames.get(frameNumber).updateScore(pinsKnocked);
    }

    public boolean isStrike(int frameNumber) {
        return frames.get(frameNumber).isStrike();
    }

    public boolean isSpare(int frameNumber) {
        return frames.get(frameNumber).isSpare();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        for (Frame frame : frames) {
            builder.append(formatFrame(frame.toString()));
            builder.append("|");
        }
        return builder.toString();
    }
}