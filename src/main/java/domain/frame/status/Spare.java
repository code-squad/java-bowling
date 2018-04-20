package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

import static domain.frame.result.ScoreMessage.convertMessage;
import static domain.frame.result.ScoreMessage.getMessage;

public class Spare implements FrameStatus {
    private Pin pin1;
    private Pin pin2;
    private int leftNum;

    public Spare(Pin pin, Pin newPin) {
        pin1 = pin;
        pin2 = newPin;
        leftNum = 1;
    }

    @Override
    public FrameStatus roll(boolean isLast, Pin newPin) throws IllegalArgumentException {
        if (!isLast) {
            return this;
        }
        return new BonusCompletion(pin1, pin2, newPin);
    }

    @Override
    public String getResultMessage() {
        return convertMessage(pin1.getNum()) + getMessage(ScoreMessage.MODIFIER) + getMessage(ScoreMessage.SPARE);
    }

    @Override
    public boolean isFinish(Frame frame) {
        return !frame.isLast();
    }

    @Override
    public Score getScore() {
        return new Score(pin1.getTotal(pin2), leftNum);
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
