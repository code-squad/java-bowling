package bowling.domain;

import bowling.enums.FrameStatus;

public class Frame {
    private Pin firstTry;
    private Pin secondTry;

    public Frame() {
    }

    public FrameStatus status() {
        return FrameStatus.getStatus(firstTry, secondTry);
    }
}
