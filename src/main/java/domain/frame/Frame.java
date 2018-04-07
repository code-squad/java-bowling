package domain.frame;

import domain.frame.result.FrameResult;

public interface Frame {

    FrameResult addScore(int score) throws IllegalArgumentException;

    boolean isFinish();
}
