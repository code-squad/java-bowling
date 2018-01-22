package domain;

public class FirstScore extends Score {
    public FirstScore(int score) {
        super(score);
    }

    public FirstScore(ScoreNumber score) {
        super(score);
    }

    public boolean isStrike() {
        return getScoreType() == ScoreType.STRIKE;
    }

    public ScoreType getScoreType() {
        return ScoreType.valueOf(score);
    }
}
