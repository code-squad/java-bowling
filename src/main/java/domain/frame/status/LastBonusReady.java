package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
import domain.frame.result.Score;

public class LastBonusReady extends LastBonusStatus {

    public LastBonusReady() {

    }

    @Override
    public FrameStatus roll(Frame frame, Pin newPin) throws IllegalArgumentException {
        return null;
    }

    @Override
    public String getResultMessage() {
        return null;
    }

    @Override
    public boolean isRegularFinish() {
        return true;
    }

    @Override
    public boolean isBonusFinish() {
        return false;
    }

    @Override
    public Score getScore() {
        return null;
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) {
        throw new CannotCalcException();
    }
}
