package bowling.domain;

import bowling.exception.CannotCalculateException;

import java.util.Objects;

public class Score {
    private int score;
    private int left;

    public Score(int score, int left) {
        this.score = score;
        this.left = left;
    }

    public Score bowl(int fallenPin) {
        return new Score(score + fallenPin, left - 1);
    }

    public int getScore() {
        if(!calculable())
            throw new CannotCalculateException();

        return this.score;
    }

    public boolean calculable() {
        return left == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return score == score1.score &&
                left == score1.left;
    }

    @Override
    public int hashCode() {

        return Objects.hash(score, left);
    }
}
