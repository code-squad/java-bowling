package domain.score;

public class Score {
    private final ScoreNumber score;
    private final ScoreType scoreType;

    public Score(int score) {
        this.score = new ScoreNumber(score);
        this.scoreType = ScoreType.valueOf(this.score);
    }

    public ScoreNumber addScore(Score o) {
        return score.add(o.score);
    }

    public boolean isStrike() {
        return scoreType == ScoreType.STRIKE;
    }

    @Override
    public String toString() {
        if (scoreType.isDisplay()) {
            return scoreType.getDisplay();
        }
        return score.toString();
    }
}
