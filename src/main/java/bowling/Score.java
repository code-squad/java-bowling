package bowling;

import static bowling.BowlingUtils.MAX_SCORE;
import static bowling.BowlingUtils.MIN_SCORE;

public class Score {
    private int score;

    private Score(int score) {
        if(!isValidScore(score)) throw new IllegalArgumentException("점수는 1~10사이만 허용됩니다.");
        this.score = score;
    }

    public static Score in(int score) {
        return new Score(score);
    }

    private boolean isValidScore(int score) {
        return MIN_SCORE <= score && score <= MAX_SCORE;
    }

    public int get() {
        return score;
    }
}
