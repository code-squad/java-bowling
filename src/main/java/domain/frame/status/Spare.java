package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
import domain.frame.result.Score;
import domain.frame.score.ScoreMessage;

public class Spare implements FrameStatus {
    private Pin pin1;
    private Pin pin2;
    private int leftNum;

    public Spare(Pin pin1, int num) {
        this.pin1 = pin1;
        pin2 = new Pin(num);
        leftNum = 1;
    }

    @Override
    public FrameStatus roll(Frame frame, int num) throws IllegalArgumentException {
        if (!frame.isLast()) {
            return this;
        }

        /* 여기도 좀 다름 - 라스트일때 */
        return this;
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
