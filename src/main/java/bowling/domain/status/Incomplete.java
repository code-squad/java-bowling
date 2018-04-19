package bowling.domain.status;

import bowling.domain.score.Score;

public abstract class Incomplete implements Status {

    public abstract Score createScore();

    public boolean isComplete() {
        return false;
    }

    public abstract int updateScore(Score score);
}
