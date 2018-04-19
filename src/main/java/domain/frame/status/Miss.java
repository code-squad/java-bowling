package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

public class Miss implements FrameStatus {
    private Pin pin1;
    private Pin pin2;

    public Miss(Pin pin, Pin newPin) {
        pin1 = pin;
        pin2 = newPin;
    }

    @Override
    public FrameStatus roll(Frame frame, Pin newPin) throws IllegalArgumentException {
        return this;
    }

    @Override
    public String getResultMessage() {
        return ScoreMessage.convertMessage(pin1.getNum()) + ScoreMessage.getMessage(ScoreMessage.MODIFIER) + ScoreMessage.convertMessage(pin2.getNum());
    }

    @Override
    public boolean isRegularFinish() {
        return true;
    }

    @Override
    public boolean isBonusFinish() {
        return true;
    }

    @Override
    public Score getScore() {
        return new Score(pin1.getTotal(pin2), 0);
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) {
        otherFrameScore.addBonusScore(pin1);
        otherFrameScore.addBonusScore(pin2);
        return otherFrameScore;
    }
}
