package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
import domain.frame.result.Score;
import domain.frame.score.ScoreMessage;

public class Ing implements FrameStatus {
    private Pin pin;

    public Ing(int num) {
        pin = new Pin(num);
    }

    @Override
    public FrameStatus roll(Frame frame, int num) throws IllegalArgumentException {
        if (pin.isOverRecordPin(num)) {
            throw new IllegalArgumentException(Pin.MAX + "개 초과 기록할 수 없습니다");
        }

        if (pin.isTotalMax(num)) {
            return new Spare(pin, num);
        }
        return new Miss(pin, num);
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
