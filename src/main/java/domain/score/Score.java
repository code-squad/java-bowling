package domain.score;

public abstract class Score {
    final ScoreNumber score;

    Score(int score) {
        this.score = new ScoreNumber(score);
    }

    Score(ScoreNumber score) {
        if (score == null) {
            throw new IllegalArgumentException();
        }
        this.score = score;
    }

    public ScoreNumber addScore(Score o) {
        return score.add(o.score);
    }

    protected abstract ScoreType getScoreType();

    @Override
    public String toString() {
        if (getScoreType().isDisplay()) {
            return getScoreType().getDisplay();
        }
        return score.toString();
    }
}
