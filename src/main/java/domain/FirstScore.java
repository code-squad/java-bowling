package domain;

public class FirstScore {
    private final ScoreNumber score;

    public FirstScore(int score) {
        this.score = new ScoreNumber(score);
    }

    public boolean isStrike() {
        return getScoreType() == ScoreType.STRIKE;
    }

    public ScoreType getScoreType() {
        return ScoreType.valueOf(score);
    }
}
