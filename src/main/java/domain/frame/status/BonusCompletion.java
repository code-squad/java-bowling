package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;
import domain.frame.result.ScoreMessage;

import static domain.frame.result.ScoreMessage.convertMessage;
import static domain.frame.result.ScoreMessage.getMessage;

public class BonusCompletion implements FrameStatus {
    private Pin pin1;
    private Pin pin2;
    private Pin pin3;

    public BonusCompletion(Pin pin1, Pin pin2, Pin newPin) {
        this.pin1 = pin1;
        this.pin2 = pin2;
        pin3 = newPin;
    }

    @Override
    public FrameStatus roll(Frame frame, Pin newPin) {
        return this;
    }

    @Override
    public String getResultMessage() {
        if (pin1.isMax()) {
            return makeResultMessageWhenStrike();
        }
        return convertMessage(pin1.getNum()) + getMessage(ScoreMessage.MODIFIER) + getMessage(ScoreMessage.SPARE) + getMessage(ScoreMessage.MODIFIER) + convertMessage(pin3.getNum());
    }

    private String makeResultMessageWhenStrike() {
        if (pin2.isMax()) {
            return getMessage(ScoreMessage.TEN) + getMessage(ScoreMessage.MODIFIER) + getMessage(ScoreMessage.TEN) + getMessage(ScoreMessage.MODIFIER) + convertMessage(pin3.getNum());
        }

        if (pin2.isMax(pin3)) {
            return getMessage(ScoreMessage.TEN) + getMessage(ScoreMessage.MODIFIER) + convertMessage(pin2.getNum()) + getMessage(ScoreMessage.MODIFIER) + getMessage(ScoreMessage.SPARE);
        }
        return getMessage(ScoreMessage.TEN) + getMessage(ScoreMessage.MODIFIER) + convertMessage(pin2.getNum()) + getMessage(ScoreMessage.MODIFIER) + convertMessage(pin3.getNum());
    }

    @Override
    public boolean isFinish(Frame frame) {
        return true;
    }

    @Override
    public Score getScore() {
        return new Score(pin1.getTotal(pin2, pin3), 0);
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
