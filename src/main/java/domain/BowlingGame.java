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
    
    public int getNextFrameNumber() {
        if (frames.isEmpty()) {
            return Frame.MIN_FRAME_NUMBER;
        }
    
        if (frames.get(frames.size() - 1).isComplete()) {
            return frames.size() + 1;
        }
    
        return frames.size();
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Frame> play(int pin) {
        Frame nowFrame = frames.isEmpty() ? new NormalFrame(pin) : frames.get(frames.size() - 1).bowl(pin);
        if (!frames.contains(nowFrame)) {
            frames.add(nowFrame);
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
