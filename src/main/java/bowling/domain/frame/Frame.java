package bowling.domain.frame;

import bowling.domain.frame.score.Score;

public abstract class Frame {

    public abstract void bowl(int pins);

    public abstract int calculateScore();

    abstract int calculateAdditionalScore(Score score);

    abstract int updateScoreFromPrevPrev(Score prevPrev);

    public abstract boolean nextIsLastFrame();
}
