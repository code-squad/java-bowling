package domain;

import static domain.ScoreNumber.TEN;

public class SecondScore extends Score {
    private final ScoreNumber firstScore;

    public SecondScore(ScoreNumber firstScore, ScoreNumber score) {
        super(score);
        if (firstScore.equals(TEN)) {
            throw new IllegalArgumentException();
        }
        score.sum(firstScore);
        this.firstScore = firstScore;
    }

    public ScoreType getScoreType() {
        return ScoreType.valueOf(firstScore, score);
    }
}
