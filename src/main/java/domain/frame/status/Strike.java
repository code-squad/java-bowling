package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
import domain.frame.result.Score;
import domain.frame.score.ScoreMessage;

public class Strike implements FrameStatus {
    private Pin pin;
    private int leftNum;

    public Strike(int num) {
        pin = new Pin(num);
        leftNum = 2;
    }

    @Override
    public FrameStatus roll(Frame frame, int num) throws IllegalArgumentException {
        if (!frame.isLast()) {
            return this;
        }
        return this;
    }

    @Override
    public String getResultMessage() {
        return ScoreMessage.getMessage(ScoreMessage.TEN);
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
        return new Score(pin.getNum(), leftNum);
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) {
        otherFrameScore.addBonusScore(pin);
        return otherFrameScore;
    }
}
