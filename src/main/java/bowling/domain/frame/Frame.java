package bowling.domain.frame;

import bowling.domain.frame.score.Score;

public interface Frame {
    int ONE_BEFORE_LAST = 9;

    int getFrameNumber();

    void bowl(int pins);

    void calculateAdditionalScore(Score score);

    void updateScoreFromPrevPrev(Score prevPrev);

    boolean isLast();

    String getPrintableStatus();

    String getPrintableScore(int accumulative);
}