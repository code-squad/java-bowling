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
        currentFrame = currentFrame.roll(num);
        // TODO : 현재 보너스 점수 개념의 점수가 입력되지않다보니 프레임 정상적인 점수도 리프레시 안됨
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
