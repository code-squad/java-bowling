package bowling.domain.frame;

import bowling.domain.frame.normal.NormalFrame;
import bowling.domain.frame.normal.score.Score;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private static final int FIRST = 1;
    private static final int INITIAL = 0;

    private final Frame frames;
    private int currentFrameNumber;

    public Frames() {
        this.frames = new NormalFrame(FIRST);
        this.currentFrameNumber = FIRST;
    }

    public void bowl(int pins) {
        Frame newFrame = frames.bowl(pins);
        if (newFrame != null) {
            currentFrameNumber++;
        }
    }

    public boolean isDone() {
        return frames.isLast();
    }

    public int getCurrentFrameNumber() {
        return currentFrameNumber;
    }

    public String convertStatusToPrintable() {
        return frames.convertStatusToPrintable();
    }

    public String convertScoreToPrintable() {
        return frames.calculateScore(INITIAL);
    }
}