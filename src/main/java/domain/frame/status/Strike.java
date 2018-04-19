package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

import static domain.frame.result.ScoreMessage.getMessage;

public class Strike implements FrameStatus {
    private Pin pin;
    private int leftNum;

    public Strike(Pin newPin) {
        pin = newPin;
        leftNum = 2;
    }

    @Override
    public FrameStatus roll(Frame frame, Pin newPin) throws IllegalArgumentException {
        if (!frame.isLast()) {
            return this;
        }

        if (newPin.isMax()) {
            return new BonusStrike(pin, newPin);
        }
        return new BonusIng(pin, newPin);
    }

    @Override
    public String getResultMessage() {
        return getMessage(ScoreMessage.TEN);
    }

    @Override
    public boolean isFinish(Frame frame) {
        return !frame.isLast();
    }

    @Override
    public Score getScore() {
        return new Score(pin.getNum(), leftNum);
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) {
        otherFrameScore.addBonusScore(pin);
        return otherFrameScore;
    }
}
