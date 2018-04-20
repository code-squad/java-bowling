package domain.frame.status;

import domain.frame.pin.Pin;
import domain.frame.result.Score;

public interface FrameStatus {

    FrameStatus roll(Pin newPin);

    String getResultMessage();

    boolean isFinish();

    Score getScore();

    Score addBonusScore(Score otherFrameScore);
}

