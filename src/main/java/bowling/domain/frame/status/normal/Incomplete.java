package bowling.domain.frame.status.normal;

import bowling.domain.frame.score.Score;

public abstract class Incomplete implements Status {

    @Override
    public Score createScore() {
        return Score.ofNotPlayed();
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public abstract boolean updateScore(Score score);

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public abstract String toString();
}