package domain.score;

public class SecondScore extends Score {
    private final FirstScore firstScore;

    public SecondScore(int firstScore, int secondScore) {
        this(new FirstScore(firstScore), new ScoreNumber(secondScore));
    }

    public SecondScore(FirstScore firstScore, ScoreNumber score) {
        super(score);
        if (firstScore.isStrike()) {
            throw new IllegalArgumentException();
        }
        this.addScore(firstScore);
        this.firstScore = firstScore;
    }

    public ScoreType getScoreType() {
        return ScoreType.valueOf(firstScore.score, score);
    }

    public boolean isSpare() {
        return getScoreType() == ScoreType.SPARE;
    }
}
