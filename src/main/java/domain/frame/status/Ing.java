package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;

import static domain.frame.result.ScoreMessage.convertMessage;

public class Ing implements FrameStatus {
    private Pin pin;

    public Ing(Pin newPin) {
        pin = newPin;
    }

    @Override
    public FrameStatus roll(Pin newPin) throws IllegalArgumentException {
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
        return convertMessage(pin.getNum());
    }

    @Override
    public boolean isFinish() {
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
