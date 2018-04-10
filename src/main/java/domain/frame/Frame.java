package domain.frame;

import domain.frame.result.score.FrameScore;

public interface Frame {
    String recordPins(int num) throws IllegalArgumentException;

    String recordBonusPins(int num) throws IllegalArgumentException;

    String convertPinNum(int num);

    FrameScore getScore();

    boolean isFinish();

    boolean isBonusFinish();

    boolean isLast();
}
