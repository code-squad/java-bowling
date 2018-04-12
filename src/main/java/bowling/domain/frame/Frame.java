package bowling.domain.frame;

import bowling.domain.score.Scores;

public abstract class Frame {
    Scores scores = new Scores();

    boolean isStrike() {
        return scores.isStrike();
    }

    boolean isSpare() {
        return scores.isSpare();
    }

    public abstract boolean updateScore(int pinsKnocked);

    @Override
    public abstract String toString();
}