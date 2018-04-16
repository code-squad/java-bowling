package bowling.domain;

import bowling.domain.Util.Parser;

import java.util.ArrayList;
import java.util.List;

public class Player implements Printable {
    private static final int LAST = 10;
    private final String name;
    private final List<Frame> frames;
    private int previouslyPlayed;

    public Player(String name) {
        this.name = name;
        this.frames = initializeFrames();
    }

    private static List<Frame> initializeFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int frameCount = 0; frameCount < LAST - 1; frameCount++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        return frames;
    }

    public int getPreviousFrameNumber() {
        return previouslyPlayed;
    }

    public boolean isLastFrame() {
        return previouslyPlayed == LAST;
    }

    private void updatePreviousFrameNumber() {
        previouslyPlayed++;
    }

    private Frame getNextFrame() {
        return frames.get(previouslyPlayed);
    }

    public boolean throwBall(int pinsKnocked) {
        Frame frame = getNextFrame();
        frame.throwBall(pinsKnocked);

        if (frame.isComplete()) {
            updatePreviousFrameNumber();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("|").append(Parser.formatFrame(name));
        for (Frame frame : frames) {
            builder.append("|").append(Parser.formatFrame(frame.toString()));
        }
        builder.append("|");
        return builder.toString();
    }
}