package domain;

import static domain.ScoreNumber.TEN;

public class SecondScore {
    private final ScoreNumber firstScore;
    private final ScoreNumber score;

    public SecondScore(ScoreNumber firstScore, ScoreNumber score) {
        if (firstScore.equals(TEN)) {
            throw new IllegalArgumentException();
        }
        score.sum(firstScore);
        this.firstScore = firstScore;
        this.score = score;
    }

    public ScoreType getScoreType() {
        return ScoreType.valueOf(firstScore, score);
    }
}
