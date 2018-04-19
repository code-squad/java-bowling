package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

import static domain.frame.result.ScoreMessage.convertMessage;
import static domain.frame.result.ScoreMessage.getMessage;

public class BonusIng implements FrameStatus {
    private Pin pin1;
    private Pin pin2;

    public BonusIng(Pin pin1, Pin newPin) {
        this.pin1 = pin1;
        pin2 = newPin;
    }

    @Override
    public FrameStatus roll(Frame frame, Pin newPin) {
        if (pin2.isOverRecordPin(newPin)) {
            throw new IllegalArgumentException(Pin.MAX + "개 까지만 기록 가능합니다.");
        }
        return new BonusCompletion(pin1, pin2, newPin);
    }

    @Override
    public String getResultMessage() {
        return convertMessage(pin1.getNum()) + getMessage(ScoreMessage.MODIFIER) + convertMessage(pin2.getNum());
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
    public Score addBonusScore(Score otherFrameScore) {
        otherFrameScore.addBonusScore(pin1);
        if (otherFrameScore.hasBonusCount()) {
            otherFrameScore.addBonusScore(pin2);
        }
        return otherFrameScore;
    }
}
