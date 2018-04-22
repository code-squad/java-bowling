package bowling.domain.frame;

import bowling.domain.frame.score.Score;

public abstract class Frame {
    public static final int ONE_BEFORE_LAST = 9;

    public abstract Frame bowl(int pins);

    public abstract boolean calculateScore(int accumulative);

    abstract boolean calculateAdditionalScore(Score score);

    abstract boolean updateScoreFromPrevPrev(Score prevPrev);

    public abstract boolean isLast();

    public abstract String
    convertStatusToPrintable();

    public abstract String convertScoreToPrintable();
}