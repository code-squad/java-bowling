package bowling.domain;

import java.util.List;

public interface Frame {
    int ALL = 10;
    int NONE = 0;

    boolean firstBallPlayed();

    boolean secondBallPlayed();

    boolean isStrike();

    boolean isSpare();

    boolean isNotValidInput(int pinsKnocked);

    Integer throwBall(int pinsKnocked);

    Integer calculateSum();

    int calculateFrameScore(List<Frame> frames, int frameNumber);

    int calculateBonus(Frame prevFrame);
}