package domain;

import domain.frame.Frames;
import domain.frame.result.FrameResults;
import domain.frame.result.score.FrameScore;

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

    public String getFrameResultMessage(int frameNum) {
        try {
            return results.getMessage(frames.getFrame(frameNum));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public FrameScore getFrameResultScore(int frameNum) {
        try {
            return results.getScore(frames.getFrame(frameNum));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
