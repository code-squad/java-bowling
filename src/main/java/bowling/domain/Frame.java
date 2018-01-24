package bowling.domain;

import bowling.enums.FrameState;
import bowling.util.PinUtil;

public class Frame {
    protected Pin firstTry;
    protected Pin secondTry;

    public Frame() {
    }

    public FrameState status() {
        return FrameState.getStatus(firstTry, secondTry);
    }

    public boolean isStrike() {
        return FrameState.isStrike(firstTry);
    }

    public boolean isSpare() {
        return FrameState.isSpare(firstTry, secondTry);
    }

    public void rollBowlingBall(Pin pin) {
        if(isFrameEnd())
            return;

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

    public boolean isFrameEnd() {
        return status().isEnd();
    }

    public String getFrameView() {
        return String.format("%1s%1s%1s",
                PinUtil.toView(firstTry),
                PinUtil.toSplitor(secondTry),
                PinUtil.toView(firstTry, secondTry));
    }
}
