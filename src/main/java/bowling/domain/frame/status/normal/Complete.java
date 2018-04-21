package bowling.domain.frame.status.normal;

import bowling.domain.frame.score.NormalScore;
import bowling.domain.frame.score.Score;

public abstract class Complete implements Status {

    @Override
    public abstract Score createScore();

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public abstract boolean updateScore(NormalScore normalScore);

    @Override
    public abstract boolean isStrike();

    @Override
    public abstract String toString();
}