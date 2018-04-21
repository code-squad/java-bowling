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

    private Frame getFrame(int frameIndex) {
        return frames.get(frameIndex);
    }

    public void bowl(int pins) {
        Frame newFrame = getFrame(currentFrameIndex).bowl(pins);
        if (newFrame != null) {
            frames.add(newFrame);
            currentFrameIndex++; //TODO: BUG - 새로운 프레임이 생겼을 때만 인덱스가 늘어난다. 그러니 당연히 마지막 프레임이 생기는 시점인 9번프레임에서 인덱스가 멈추게 된다.
        }
    }

    public void calculateScores() {
        frames.forEach(Frame::calculateScore);
    }

    public boolean isDone() {
        return getFrame(currentFrameIndex).isLast();
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