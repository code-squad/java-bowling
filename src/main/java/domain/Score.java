package domain;

import java.util.Objects;

import static domain.Figure.STRIKE;
import static domain.Figure.ZERO;

public class Score {

    private int score;
    private static final int MAX_FRAME_SCORE = 10;
    private static final int MIN_FRAME_SCORE = 0;

    private Score() {
        this.score = MIN_FRAME_SCORE;
    }

    private Score(final int n) {
        if (!isValidScore(n)) {
            throw new IllegalArgumentException("0에서 10사이의 값을 넣어주세요.");
        }
        this.score = n;
    }

    public static Score of() {
        return new Score();
    }

    public static Score of(final int score) {
        return new Score(score);
    }

    private static boolean isValidScore(final int n) {
        return MIN_FRAME_SCORE <= n && n <= MAX_FRAME_SCORE;
    }

    public void sum(Score otherScore) {
        this.score += otherScore.score;
    }

    public boolean isTen() {
        return score == MAX_FRAME_SCORE;
    }

    public boolean isValidAdditionScore(final int score) {
        return score <= MAX_FRAME_SCORE - this.score;
    }

    public int getScore() {
        return score;
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
        if (score == MIN_FRAME_SCORE) return ZERO.toString();
        if (score == MAX_FRAME_SCORE) return STRIKE.toString();
        return Integer.toString(score);
    }

    public boolean isBonusOverThirty() {
        return score + 10 >= 30;
    }

    public void sum(int i) {
        score += i;
    }

    public boolean isOverTen() {
        return score > 10;
    }
}

