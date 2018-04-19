package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.Score;

public interface FrameStatus {

    FrameStatus roll(Frame frame, Pin newPin);

    String getResultMessage();

    boolean isFinish(Frame frame);

    Score getScore();

    Score addBonusScore(Score otherFrameScore);
}

