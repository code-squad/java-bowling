package bowling.domain.frame;

import bowling.domain.frame.score.Score;

public abstract class Frame {

    public abstract Frame bowl(int pins);

    public abstract void calculateScore();

    abstract void calculateAdditionalScore(Score normalScore);

    abstract void updateScoreFromPrevPrev(Score prevPrev);

    public abstract boolean isLast();

    public abstract String convertStatusToPrintable();

    public abstract String convertScoreToPrintable();
}