package bowling.domain.status;

import bowling.domain.score.Score;

public abstract class Complete implements Status {

    public abstract Score createScore();

    public boolean isComplete() {
        return true;
    }

    public abstract int updateScore(Score score);
}
