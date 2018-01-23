package domain.score;

public class TotalScore {
    private final Score firstScore;
    private Score secondScore;

    public TotalScore(Score firstScore) {
        this.firstScore = firstScore;
        this.secondScore = null;
    }

    public void addSecondScore(Score secondScore) {
        if (getType() != ScoreType.UNDEFINED) {
            throw new IllegalStateException();
        }
        secondScore.addScore(firstScore);
        this.secondScore = secondScore;
    }

    public boolean isStrike() {
        return firstScore.isStrike();
    }

    public boolean isSpare() {
        return getType() == ScoreType.SPARE;
    }

    ScoreType getType() {
        if (secondScore == null && !firstScore.isStrike()) {
            return ScoreType.UNDEFINED;
        }
        return ScoreType.valueOf(this);
    }

    ScoreNumber sumOfScore() {
        return firstScore.addScore(secondScore);
    }

    @Override
    public String toString() {
        if (isStrike() || secondScore == null) {
            return firstScore.toString();
        }
        if (isSpare()) {
            return firstScore.toString() + "|" + ScoreType.SPARE.getDisplay();
        }
        return firstScore.toString() + "|" + secondScore.toString();
    }
}
