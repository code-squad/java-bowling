package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

import static domain.frame.result.ScoreMessage.convertMessage;
import static domain.frame.result.ScoreMessage.getMessage;

public class Miss implements FrameStatus {
    private Pin pin1;
    private Pin pin2;

    public Miss(Pin pin, Pin newPin) {
        pin1 = pin;
        pin2 = newPin;
    }

    @Override
    public FrameStatus roll(Pin newPin) throws IllegalArgumentException {
        return this;
    }

    @Override
    public String getResultMessage() {
        return convertMessage(pin1.getNum()) + getMessage(ScoreMessage.MODIFIER) + convertMessage(pin2.getNum());
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public Score getScore() {
        return new Score(pin1.getTotal(pin2), 0);
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
