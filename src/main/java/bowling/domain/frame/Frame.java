package bowling.domain.frame;

import bowling.domain.frame.score.Score;

public interface Frame {
    int ONE_BEFORE_LAST = 9;

    void bowl(int pins);

    void calculateAdditionalScore(Score score);

    void updateScoreFromPrevPrev(Score prevPrev);

    String getPrintableStatus();

    String getPrintableScore(int accumulative);

    boolean isLastFrame();

    boolean isNewFrame();
}