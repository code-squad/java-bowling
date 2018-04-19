package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
import domain.frame.result.Score;

public class Ready implements FrameStatus {

    @Override
    public FrameStatus roll(Frame frame, Pin newPin) throws IllegalArgumentException {
        if (newPin.isMax()) {
            return new Strike(newPin);
        }
        return new Ing(newPin);
    }

    @Override
    public String getResultMessage() {
        return "";
    }

    @Override
    public boolean isFinish(Frame frame) {
        return false;
    }

    @Override
    public Score getScore() {
        return null;
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) throws CannotCalcException {
        throw new CannotCalcException();
    }
}
