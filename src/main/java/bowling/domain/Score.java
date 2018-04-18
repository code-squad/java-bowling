package bowling.domain;

public class Score {
    private int score;
    private int countUntilCalculation;

    public void decreaseCountUntilCalculation() {
        countUntilCalculation--;
    }

    public void updateScore(int score) {
        this.score = score;
    }
}