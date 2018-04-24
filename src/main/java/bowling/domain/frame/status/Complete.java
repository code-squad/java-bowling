package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

abstract class Complete implements Status {

    @Override
    public abstract Score createScore();

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public boolean isPlayed() {
        return true;
    }

    @Override
    public abstract void updateScore(Score score);

    @Override
    public abstract boolean isStrike();

    @Override
    public abstract boolean isSpare();

    @Override
    public abstract String toString();
}