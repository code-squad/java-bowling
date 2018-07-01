package bowling.domain;

import java.util.List;

public class Game {
    private Frames frames;
    private int currentFrame;

    public Game() {
        frames = new Frames();
        currentFrame = 1;
        frames.add(currentFrame);
    }

    public void roll(int pins) {
        frames.roll(pins);
    }

    public List<Frame> getFrames() {
        return frames.getAll();
    }

    public boolean isEnd() {
        return frames.isAllFramesEnd();
    }

    public int getCurrentFrame() {
        return frames.rollFrameId();
    }
}
