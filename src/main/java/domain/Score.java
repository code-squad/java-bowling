package domain;

public class Score {
    private static final int NO_LEFT = 0;
    private static final int MAX_PINS = 10;

    private int score;
    private int left;

    public Score(int score, int left) {
        this.score = score;
        this.left = left;
    }

    public static Score ofOpen(Pins first, Pins second) {
        return new Score(Pins.sumPins(first, second), 0);
    }

    public static Score ofSpare() {
        return new Score(MAX_PINS, 1);
    }

    public static Score ofStrike() {
        return new Score(MAX_PINS, 2);
    }

    public Score bowl(Pins falledPins) {
        return new Score(score = falledPins.sumScore(score), left -= 1);
    }

    public int getScore() {
        return this.score;
    }

    public int getLeft() {
        return this.left;
    }

    public boolean canCalculateScore() {
        return left == NO_LEFT;
    }

    public Score calculateScore(int score) {
        return new Score(this.score + score, left);
    }

    @Override
    public String toString() {
        return "score : " + score + " left : " + left;
    }
}
