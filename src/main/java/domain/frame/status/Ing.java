package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

public class Ing implements FrameStatus {
    private Pin pin;

    public Ing(Pin newPin) {
        pin = newPin;
    }

    @Override
    public FrameStatus roll(Frame frame, Pin newPin) throws IllegalArgumentException {
        if (pin.isOverRecordPin(newPin)) {
            throw new IllegalArgumentException(Pin.MAX + "개 초과 기록할 수 없습니다");
        }

        if (pin.isMax(newPin)) {
            return new Spare(pin, newPin);
        }
        return new Miss(pin, newPin);
    }

    @Override
    public String getResultMessage() {
        return ScoreMessage.convertMessage(pin.getNum());
    }

    @Override
    public boolean isRegularFinish() {
        return false;
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
        otherFrameScore.addBonusScore(pin);
        return otherFrameScore;
    }
}
