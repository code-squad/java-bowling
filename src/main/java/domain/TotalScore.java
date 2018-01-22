package domain;

public class TotalScore {
    private final FirstScore firstScore;
    private final SecondScore secondScore;

    public TotalScore(int firstScore, int secondScore) {
        this(new FirstScore(firstScore), new SecondScore(firstScore, secondScore));
    }

    public TotalScore(FirstScore firstScore, SecondScore secondScore) {
        if (firstScore.isStrike()) {
            throw new IllegalArgumentException();
        }
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public TotalScore(FirstScore firstScore) {
        if (!firstScore.isStrike()) {
            throw new IllegalArgumentException();
        }
        this.firstScore = firstScore;
        this.secondScore = null;
    }

    public ScoreType getType() {
        if (firstScore.isStrike()) {
            return ScoreType.STRIKE;
        }
        if (secondScore.isSpare()) {
            return ScoreType.SPARE;
        }
        return ScoreType.MISS;
    }

    @Override
    public String toString() {
        if (firstScore.isStrike()) {
            return firstScore.toString();
        }
        return firstScore.toString() + "|" + secondScore.toString();
    }
}
