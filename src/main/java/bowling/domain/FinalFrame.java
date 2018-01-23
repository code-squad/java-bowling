package bowling.domain;

import bowling.enums.FrameStatus;
import bowling.util.PinUtil;

import static bowling.enums.FrameStatus.SPARE;
import static bowling.enums.FrameStatus.STRIKE;

public class FinalFrame extends Frame {
    private Pin thirdTry;

    @Override
    public void rollBowlingBall(Pin pin) {
        if(isFrameEnd())
            return;

        if(firstTry == null) {
            firstBowl(pin);
            return;
        }

        if(secondTry == null) {
            secondBowl(pin);
            return;
        }

        thirdBowl(pin);
    }

    private void thirdBowl(Pin pin) {
        thirdBowlInputCheck(pin);
        thirdTry = pin;
    }

    private void thirdBowlInputCheck(Pin pin) {
        if(firstTry == null || secondTry == null)
            throw new IllegalArgumentException("Invalid try, first try or second try is not attempted");
        if((firstTry.isStrike() && !secondTry.isStrike()) && secondTry.isOverTen(pin))
            throw new IllegalArgumentException("Third try num make total pin over 10");
    }

    @Override
    public void secondBowl(Pin pin) {
        if(status() != STRIKE) {
            super.secondBowl(pin);
            return;
        }

        secondTry = pin;
    }

    @Override
    public FrameStatus status() {
        return super.status();
    }

    @Override
    public boolean isFrameEnd() {
        FrameStatus status = status();
        if(status == STRIKE || status == SPARE)
            return thirdTry != null;

        return super.isFrameEnd();
    }

    @Override
    public String getFrameView() {
        return String.format("%1s%1s%1s",
                PinUtil.toView(firstTry),
                PinUtil.toSplitor(secondTry),
                PinUtil.toView(firstTry, secondTry));
    }
}
