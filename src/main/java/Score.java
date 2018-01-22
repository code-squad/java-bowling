public class Score {
    private int score;

    private Score(int score) {
        if(!isValidScore(score)) throw new IllegalArgumentException();
        this.score = score;
    }

    public static Score in(int score) {
        return new Score(score);
    }

    private boolean isValidScore(int score) {
        return BowlingUtils.MIN_SCORE <= score && score <= BowlingUtils.MAX_SCORE;
    }

    public int get() {
        return score;
    }
}
