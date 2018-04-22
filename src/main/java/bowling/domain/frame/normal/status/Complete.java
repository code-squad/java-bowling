package bowling.domain.frame.normal.status;

import bowling.domain.frame.normal.score.Score;

public abstract class Complete implements Status {

    @Override
    public abstract Score createScore();

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public abstract boolean updateScore(Score score);

    @Override
    public abstract boolean isStrike();

    @Override
    public abstract String toString();
}