package bowling.domain.frame.score;

import bowling.domain.util.Formatter;

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

    public int bowl(int score) {
        return this.score += score;
    }

    public boolean noMoreBowlNeeded() { //TODO: Needed??
        return countUntilCalculation == 0;
    }

    public boolean oneMoreBowlNeeded() {
        return countUntilCalculation == 1;
    }

    public boolean twoMoreBowlsNeeded() {
        return countUntilCalculation == 2;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}