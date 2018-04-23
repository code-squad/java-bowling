package bowling.domain.frame.normal.status;

import bowling.domain.frame.normal.score.Score;

abstract class Incomplete implements Status {

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