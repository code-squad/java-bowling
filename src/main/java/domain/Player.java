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

    public FrameResults recordScore(int score) {
        results.addResult(frames.getCurrentFrameIdx(), frames.recordScore(score));
        return results;
    }

    public int getCurrentFrameNum() {
        return frames.getCurrentFrameNum();
    }

    public FrameResults getResults() {
        return results;
    }
}
