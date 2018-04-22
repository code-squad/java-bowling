package bowling.domain.frame;

import bowling.domain.frame.normal.score.Score;

public abstract class Frame {
    public static final int ONE_BEFORE_LAST = 9;

    public abstract Frame bowl(int pins);

    public abstract boolean calculateScore(int accumulative);

    public abstract boolean calculateAdditionalScore(Score score);

    public abstract boolean updateScoreFromPrevPrev(Score prevPrev);

    public abstract boolean isLast();

    public abstract String
    convertStatusToPrintable();

    public abstract String convertScoreToPrintable();
}