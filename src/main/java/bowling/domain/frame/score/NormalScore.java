package bowling.domain.frame.score;

public class NormalScore {
    private final boolean isComplete;
    private int countUntilCalculation;
    private int score;

    public NormalScore(int score){
        this.isComplete = false;
    }

    private NormalScore(int score, int countUntilCalculation) {
        this.isComplete = true;
        this.score = score;
        this.countUntilCalculation = countUntilCalculation;
    }

    public static NormalScore ofStrike() {
        return new NormalScore(10, 2);
    }

    public static NormalScore ofSpare() {
        return new NormalScore(10, 1);
    }

    public static NormalScore ofNormal(int score) {
        return new NormalScore(score, 0);
    }

    public void bowl(int score) {
        if (countUntilCalculation != 0) {
            countUntilCalculation -= 1;
            this.score += score;
        }
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
        if (!isComplete) {
            return "";
        }
        return String.valueOf(score);
    }
}