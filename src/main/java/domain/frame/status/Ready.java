package domain.frame.status;

import domain.frame.pin.Pin;
import domain.frame.result.Score;

public class Ready implements FrameStatus {

    @Override
    public FrameStatus roll(Pin newPin) throws IllegalArgumentException {
        if (newPin.isMax()) {
            return new Strike(newPin);
        }
        return new FirstBowl(newPin);
    }

    @Override
    public String getResultMessage() {
        return "";
    }

    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public Score getScore() {
        return new Score(0, 0);
    }

    @Override
    public Score addBonusScore(Score otherFrameScore) {
        return otherFrameScore;
    }
}
