package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

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
    public FrameStatus roll(Frame frame, Pin newPin) throws IllegalArgumentException {
        if (!frame.isLast()) {
            return this;
        }
        return null;
    }

    @Override
    public String getResultMessage() {
        return ScoreMessage.convertMessage(pin1.getNum()) + ScoreMessage.getMessage(ScoreMessage.MODIFIER) + ScoreMessage.getMessage(ScoreMessage.SPARE);
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
        return new Score(pin1.getTotal(pin2), leftNum);
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) {
        otherFrameScore.addBonusScore(pin1);
        otherFrameScore.addBonusScore(pin2);
        return otherFrameScore;
    }
}
