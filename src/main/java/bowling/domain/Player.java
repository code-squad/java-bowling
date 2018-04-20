package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.util.Formatter;

import java.util.ArrayList;
import java.util.List;

public class Player implements Printable {
    private final String name;
    private final List<Frame> frames = new ArrayList<>(); //TODO: wrapper class -> Frames
    private int currentFrameIndex;

    public Player(String name) {
        this.name = name;
        this.currentFrameIndex = 0;
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

    public boolean isDone() {
        return getCurrentFrame().isLast();
    }

    @Override
    public String convertToPrintable() {
        return "|" + Formatter.formatFrame(name) + "|" + frames.get(0);
    }
}