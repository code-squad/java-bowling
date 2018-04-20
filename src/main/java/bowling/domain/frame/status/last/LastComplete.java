package bowling.domain.frame.status.last;

import bowling.domain.frame.score.Score;

public abstract class LastComplete implements LastFrameStatus{

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public abstract Score createScore();

    @Override
    public abstract int updateScore(Score score);

    @Override
    public abstract String toString();
}
