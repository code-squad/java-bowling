package domain;

import domain.frame.Frame;
import domain.frame.Frames;
import domain.frame.NormalFrame;

public class BowlingGame {
    private String playerName;
    private Frames frames;

    public BowlingGame(String playerName) {
        this.playerName = playerName;
        this.frames = new Frames();
    }
    
    public Frames getFrames() {
        return frames;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Frames play(int pin) {
        Frame nowFrame = frames.isEmpty() ? new NormalFrame(pin) : frames.getLast().bowl(pin);
        if (!frames.contains(nowFrame)) {
            frames.add(nowFrame);
        }
        return frames;
    }

    public boolean canPlay() {
        if(frames.isEmpty()) {
            return true;
        }

        Frame lastFrame = frames.getLast();
        return !lastFrame.isFinalFrame() || !lastFrame.isComplete();
    }
}
