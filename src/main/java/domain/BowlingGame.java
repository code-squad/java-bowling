package domain;

import domain.frame.Frame;
import domain.frame.NormalFrame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Frame> frames;
    private String playerName;

    public BowlingGame(String playerName) {
        this.playerName = playerName;
        this.frames = new ArrayList<>();
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Frame> play(int pinCount) {
        Frame currentFrame = frames.isEmpty() ? new NormalFrame(pinCount) : frames.get(frames.size() - 1).bowl(pinCount);
        if (!frames.contains(currentFrame)) {
            frames.add(currentFrame);
        }
        return frames;
    }

    public boolean canPlay() {
        if(frames.isEmpty()) {
            return true;
        }

        Frame lastFrame = frames.get(frames.size() - 1);
        return !lastFrame.isFinalFrame() || !lastFrame.isComplete();
    }
}
