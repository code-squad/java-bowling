package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

import static domain.frame.result.ScoreMessage.getMessage;

public class BonusStrike implements FrameStatus {
    private Pin pin1;
    private Pin pin2;
    private int leftNum;

    public BonusStrike(Pin pin1, Pin newPin) {
        this.pin1 = pin1;
        pin2 = newPin;
        leftNum = 1;
    }

    @Override
    public FrameStatus roll(boolean isLast, Pin newPin) {
        return new BonusCompletion(pin1, pin2, newPin);
    }

    @Override
    public String getResultMessage() {
        return getMessage(ScoreMessage.TEN) + getMessage(ScoreMessage.MODIFIER) + getMessage(ScoreMessage.TEN);
    }

    @Override
    public boolean isFinish(Frame frame) {
        return false;
    }

    @Override
    public Score getScore() {
        return new Score(Frame.CANNOT_CALC_SCORE_STATE, leftNum);
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) throws CannotCalcException {
        otherFrameScore.addBonusScore(pin1);
        if (otherFrameScore.hasBonusCount()) {
            otherFrameScore.addBonusScore(pin2);
        }
        return otherFrameScore;
    }
}
