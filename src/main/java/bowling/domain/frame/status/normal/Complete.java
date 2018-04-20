package bowling.domain.frame.status.normal;

import bowling.domain.frame.score.Score;

public abstract class Complete implements Status {

    @Override
    public abstract Score createScore();

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public abstract int updateScore(Score score);

    @Override
    public abstract boolean isStrike();

    @Override
    public abstract String toString();
}