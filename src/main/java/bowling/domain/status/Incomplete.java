package bowling.domain.status;

import bowling.domain.score.Score;

public abstract class Incomplete implements Status {

    @Override
    public abstract Score createScore();

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public abstract int updateScore(Score score);

    @Override
    public boolean isStrike() {
        return false;
    }
}