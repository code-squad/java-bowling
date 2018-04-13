package domain;

import domain.frame.Frames;

public class Player {
    private PlayerName name;
    private Frames frames;

    public Player(String name) throws IllegalArgumentException {
        this.name = new PlayerName(name);
        frames = new Frames();
    }

    public void roll(int num) throws IllegalArgumentException {
        frames.roll(num);
    }

    public boolean isFinish() {
        return frames.isFinish();
    }

    public int getCurrentFrameNum() {
        return frames.getFrameNum();
    }
}
