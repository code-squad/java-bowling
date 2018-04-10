package domain;

import java.util.Objects;

import static domain.Figure.STRIKE;
import static domain.Figure.ZERO;

public class Score {

    private int score;

    private Score() {
        this.score = 0;
    }

    private Score(int n) {
        if (!isValidScore(n)) {
            throw new IllegalArgumentException("0에서 10사이의 값을 넣어주세요.");
        }
        this.score = n;
    }

    public static Score of() {
        return new Score();
    }

    public static Score of(int score) {
        return new Score(score);
    }

    public void sum(Score otherScore) {
        this.score += otherScore.score;
    }

    public boolean isTen() {
        return score == 10;
    }

    public boolean isUnderTen() {
        return score < 10;
    }

    public boolean isUnderTwenty() {
        return score <= 20;
    }

    public boolean isValidAdditionScore(int score) {
        return score <= 10 - this.score;
    }

    public int getScore() {
        return score;
    }

    private static boolean isValidScore(int n) {
        return 0 <= n && n <= 10;
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
        if (score == 0) return ZERO.toString();
        if (score == 10) return STRIKE.toString();
        return Integer.toString(score);
    }

}

