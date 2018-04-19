package bowling.domain.score;

public class Score {
    private int countUntilCalculation;
    private int score;

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

    public void bowl(int score) {
        this.score += score;
        if (!countUntilCalcIsZero()) {
            countUntilCalculation--;

        }
    }

    public boolean countUntilCalcIsZero() {
        return countUntilCalculation == 0;
    }

    public boolean countUntilCalcIsOne() {
        return countUntilCalculation == 1;
    }
}