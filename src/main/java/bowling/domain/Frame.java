package bowling.domain;

import bowling.enums.FrameStatus;

public class Frame {
    private static final String FRAME_VIEW = "      ";
    private Pin firstTry;
    private Pin secondTry;

    public Frame() {
    }

    public FrameStatus status() {
        return FrameStatus.getStatus(firstTry, secondTry);
    }

    public String printFrame() {
        return FRAME_VIEW;
    }
}
