package bowling.domain.frame.score;

public class LastFrameScore {
    private int score;

    public void updateScore(int score) {
        this.score += score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}