package bowling.domain;

import bowling.util.PinUtil;

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
        if(!isStrike()) {
            super.secondBowl(pin);
            return;
        }

        secondTry = pin;
    }

    @Override
    public boolean isFrameEnd() {
        if(isStrike() || isSpare())
            return thirdTry != null;

        return super.isFrameEnd();
    }

    @Override
    public String getFrameView() {
        if(isStrike())
            return String.format("%1s%2s",
                    PinUtil.toView(firstTry),
                    PinUtil.frameView(secondTry, thirdTry)
            );

        return String.format("%2s%1s",
                PinUtil.frameView(firstTry, secondTry),
                PinUtil.toView(thirdTry)
        );
    }
}
