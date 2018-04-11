package domain;

import domain.frame.Frames;
import domain.frame.result.FrameResults;

public class Player {
    private PlayerName name;
    private Frames frames;
    private FrameResults results;

    public Player(String name) throws IllegalArgumentException {
        this.name = new PlayerName(name);
        frames = new Frames();
        results = new FrameResults();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isFinish() {
        return frames.isFinish();
    }

    public void recordPins(int pins) throws IllegalArgumentException {
        frames.recordPins(results, pins);
    }

    public int getCurrentFrameNum() {
        return frames.getCurrentFrameNum();
    }
}
