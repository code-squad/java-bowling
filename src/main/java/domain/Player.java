package domain;

import domain.frame.Frame;
import domain.frame.result.Board;

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
        firstFrame.bonusRoll(currentFrame, num);
        currentFrame = currentFrame.roll(num);
    }

    public boolean isFinish() {
        return currentFrame.isLast() && currentFrame.isFinish();
    }

    public int getCurrentFrameNum() {
        return currentFrame.getFrameNum();
    }

    public Board getResult() {
        return firstFrame.getBoard();
    }
}
