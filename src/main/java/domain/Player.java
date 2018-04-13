package domain;

import domain.frame.Frame;

public class Player {
    private PlayerName name;
    private Frame firstFrame;
    private Frame currentFrame;

    public Player(String name) throws IllegalArgumentException {
        this.name = new PlayerName(name);
        firstFrame = Frame.of(1);
        currentFrame = firstFrame;
    }

    public void roll(int num) throws IllegalArgumentException {
        currentFrame = currentFrame.roll(num);
    }

    public boolean isFinish() {
        return currentFrame.isLast() && currentFrame.isFinish();
    }

    public int getCurrentFrameNum() {
        return currentFrame.getFrameNum();
    }
}
