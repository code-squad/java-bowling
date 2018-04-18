package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
import domain.frame.result.Score;

public class Ready implements FrameStatus {

    @Override
    public FrameStatus roll(Frame frame, int num) throws IllegalArgumentException {
        if (!Pin.isValidRange(num)) {
            throw new IllegalArgumentException(Pin.MAX + "개를 넘을 수 없습니다.");
        }

        if (Pin.isMax(num)) {
            return new Strike(num);
        }
        return new Ing(num);
    }

    @Override
    public String getResultMessage() {
        return "";
    }

    @Override
    public boolean isRegularFinish() {
        return false;
    }

    @Override
    public boolean isBonusFinish() {
        return true;
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
