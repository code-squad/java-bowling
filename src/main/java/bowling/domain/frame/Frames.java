package bowling.domain.frame;

import java.util.ArrayList;
import java.util.List;

import static bowling.domain.Utils.Formatter.formatFrame;

public class Frames {
    private final List<Frame> frames;

    public Frames() {
        this.frames = initializeFrames();
    }

    private List<Frame> initializeFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int frameNumber = 0; frameNumber < 9; frameNumber++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        return frames;
    }

    public boolean knockPins(int frameNumber, int pinsKnocked) {
        return onFrame(frameNumber).knockPins(pinsKnocked);
    }

    public boolean isStrike(int frameNumber) {
        return onFrame(frameNumber).isStrike();
    }

    public boolean isSpare(int frameNumber) {
        return onFrame(frameNumber).isSpare();
    }

    private Frame onFrame(int frameNumber) {
        return frames.get(frameNumber);
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