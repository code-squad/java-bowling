package domain;

import java.util.Objects;

public class Score {

    int score;

    private Score(int n) {
        this.score = n;
    }

    private Score() {
        this.score = 0;
    }

    public static Score of() {
        return new Score();
    }

    public static Score of(int score) {
        return new Score(score);
    }

    public Score sum(Score otherScore) {
        score += otherScore.score;
        return new Score(score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return score == score1.score;
    }

    @Override
    public int hashCode() {

        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return Integer.toString(score);
    }
}

