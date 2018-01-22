package bowling.domain;

import bowling.enums.FrameStatus;

import java.text.MessageFormat;

public class Frame {
    private static final String FRAME_VIEW = "  {0} ";
    private Pin firstTry;
    private Pin secondTry;

    public Frame() {
    }

    public FrameStatus status() {
        return FrameStatus.getStatus(firstTry, secondTry);
    }

    public String printFrame() {
        return MessageFormat.format(FRAME_VIEW, FrameStatus.toView(firstTry, secondTry));
    }

    public void rollBowlingBall(Pin pin) {
        if(firstTry == null) {
            firstBowl(pin);
            return;
        }
        secondBowl(pin);
    }

    public void firstBowl(Pin pin) {
        firstTry = pin;
    }

    public void secondBowl(Pin pin) {
        secondBowlInputCheck(pin);
        secondTry = pin;
    }

    private void secondBowlInputCheck(Pin pin) {
        if(firstTry == null)
            throw new IllegalArgumentException("Invalid try, first try is not attempted");
        if(firstTry.isOverTen(pin))
            throw new IllegalArgumentException("SecondTry num make total pin over 10");
    }
}
