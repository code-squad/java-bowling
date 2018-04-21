package bowling.domain.frame;

import bowling.domain.util.Formatter;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private final List<Frame> frames;
    private int currentFrameIndex;

    public Frames() {
        this.frames = new ArrayList<>();
        frames.add(new NormalFrame(1));
    }

    private Frame getCurrentFrame() {
        return frames.get(currentFrameIndex);
    }

    public void bowl(int pins) {
        Frame newFrame = getCurrentFrame().bowl(pins);
        if (newFrame != null) {
            frames.add(newFrame);
            currentFrameIndex++;
        }
    }

    public void calculateScores() {
        frames.forEach(Frame::calculateScore);
    }

    public boolean isDone() {
        return currentFrameIndex == 9;
    }

    public int getCurrentFrameNumber() {
        return currentFrameIndex + 1;
    }

    public String convertStatusToPrintable() {
        StringBuilder builder = new StringBuilder();
        for (Frame frame : frames) {
            builder.append(frame.convertStatusToPrintable());
            builder.append("|");
        }
        return builder.toString();
    }

    public String convertScoreToPrintable() {
        StringBuilder builder = new StringBuilder();
        builder.append("|");
        builder.append(Formatter.formatFrame(""));
        builder.append("|");
        for (Frame frame : frames) {
            builder.append(frame.convertScoreToPrintable());
            builder.append("|");
        }
        return builder.toString();
    }
}