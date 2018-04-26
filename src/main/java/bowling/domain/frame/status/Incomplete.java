package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

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
    public abstract boolean isPlayed();

    @Override
    public abstract void updateScore(Score score);

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return false;
    }

    @Override
    public boolean isMiss() {
        return false;
    }

    @Override
    public abstract String toString();
}