package domain;

public class ScoreNumber {
    public static final ScoreNumber ZERO = new ScoreNumber(0);
    public static final ScoreNumber TEN = new ScoreNumber(10);

    private final int score;

    public ScoreNumber(int score) {
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException();
        }
        this.score = score;
    }

    public ScoreNumber add(ScoreNumber o1) {
        return new ScoreNumber(score + o1.score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof ScoreNumber)) { return false; }

        ScoreNumber that = (ScoreNumber) o;

        return score == that.score;
    }

    @Override
    public int hashCode() {
        return score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}
