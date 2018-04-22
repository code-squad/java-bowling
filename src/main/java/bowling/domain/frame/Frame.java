package bowling.domain.frame;

import bowling.domain.frame.normal.score.Score;

public interface Frame {
    int ONE_BEFORE_LAST = 9;

    Frame bowl(int pins);

    boolean calculateScore(int accumulative);

    boolean calculateAdditionalScore(Score score);

    boolean updateScoreFromPrevPrev(Score prevPrev);

    boolean isLast();

    String convertStatusToPrintable();

    String convertScoreToPrintable();
}