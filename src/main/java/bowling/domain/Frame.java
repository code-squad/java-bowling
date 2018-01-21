package bowling.domain;

import bowling.enums.FrameStatus;

public class Frame {
    private int firstTry;
    private int secondTry;

    public Frame() {
        this(-1, -1);
    }

    public Frame(int firstTry, int secondTry) {
        this.firstTry = firstTry;
        this.secondTry = secondTry;
    }

    public FrameStatus status() {
        return FrameStatus.valueOf(firstTry, secondTry);
    }
}
