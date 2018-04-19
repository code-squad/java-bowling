package bowling.domain.score;

public class Score {
    private int score;
    private int countUntilCalculation;

    public void decreaseCountUntilCalculation() {
        countUntilCalculation--;
    }

    public void updateScore(int score) {
        this.score = score;
    }

    public boolean readyForCalculation() {
        return countUntilCalculation >= 0;
    }

    public int getScore() {
        return score;
    }
}