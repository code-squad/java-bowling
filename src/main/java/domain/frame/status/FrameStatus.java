package domain.frame.status;

import domain.frame.Frame;
import domain.frame.result.Score;

public interface FrameStatus {

    static FrameStatus getInitStatus() {
        return new Ready();
    }

    FrameStatus roll(Frame frame, int num) throws IllegalArgumentException;

    String getResultMessage();

    boolean isRegularFinish();

    boolean isBonusFinish();

    Score getScore();

    Score addBonusScore(Score otherFrameScore);
}

