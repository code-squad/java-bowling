package domain.score;

public class Score {
    private final ScoreNumber score;

    public Score(int score) {
        this.score = new ScoreNumber(score);
    }

    public ScoreNumber addScore(Score o) {
        return score.add(o.score);
    }

    public boolean isStrike() {
        return getScoreType() == ScoreType.STRIKE;
    }

    public ScoreType getScoreType() {
        return ScoreType.valueOf(score);
    }

    @Override
    public String toString() {
        if (getScoreType().isDisplay()) {
            return getScoreType().getDisplay();
        }
        return score.toString();
    }
}
