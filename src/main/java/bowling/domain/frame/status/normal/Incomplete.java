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
    public abstract boolean updateScore(Score score); //TODO: don't need this since there's nothing to update

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public abstract String toString();
}