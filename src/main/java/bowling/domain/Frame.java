package bowling.domain;

import java.util.List;

public interface Frame {
    int ALL = 10;
    int NONE = 0;

    boolean isStrike();

    boolean isSpare();

    boolean firstBallNotPlayed();

    boolean secondBallNotPlayed();

    boolean throwBall(int pinsKnocked);

    Integer calculateFrameScore(List<Frame> frames, int frameNumber);

    Integer calculateBonus(Frame prevFrame);

    boolean isComplete();
}