package domain.frame.status;

import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

import static domain.frame.result.ScoreMessage.getMessage;

public class Strike implements FrameStatus {
    private Pin pin;

    public Strike(Pin newPin) {
        pin = newPin;
    }

    @Override
    public FrameStatus roll(Pin newPin) throws IllegalArgumentException {
        return this;
    }

    @Override
    public String getResultMessage() {
        return getMessage(ScoreMessage.TEN);
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public Score getScore() {
        return new Score(pin.getNum(), 2);
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) {
        otherFrameScore.addBonusScore(pin);
        return otherFrameScore;
    }
}
