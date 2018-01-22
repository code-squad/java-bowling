package domain;

public abstract class Score {
    final ScoreNumber score;

    Score(int score) {
        this.score = new ScoreNumber(score);
    }

    Score(ScoreNumber score) {
        this.score = score;
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
