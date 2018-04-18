package bowling.domain;

public class Score {
    private int score;
    private int countUntilCalculation;

    private Score(int score, int countUntilCalculation) {
        this.score = score;
        this.countUntilCalculation = countUntilCalculation;
    }

    public static Score ofStrike() {
        return new Score(10, 2);
    }

    public static Score ofSpare() {
        return new Score(10, 1);
    }

    public static Score ofNormal(int score) {
        return new Score(score, 0);
    }

    public Score bowl(int pins) {
        if (countUntilCalculation != 0) {
            this.countUntilCalculation--;
            return this;
        }
        return new Score(score += pins, countUntilCalculation);
    }

    public int getScore() {
        if (!canBeCalculated()) {
            throw new CannotBeCalculatedException();
        }
        return score;
    }

    public boolean canBeCalculated() {
        return countUntilCalculation == 0;
    }
}