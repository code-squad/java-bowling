package domain;

public class Score {
    private static final int NO_LEFT = 0;
    private int score;
    private int left;

    public Score(int score, int left) {
        this.score = score;
        this.left = left;
    }

    public static Score ofOpen(int first, int second) {
        return new Score(first + second, 0);
    }

    public static Score ofSpare() {
        return new Score(10, 1);
    }

    public static Score ofStrike() {
        return new Score(10, 2);
    }

    public Score throwing(int pins) {
        return new Score(score += pins, left - 1);
    }

    public int getScore() {
        if (!canCalculateScore()) {
            throw new RuntimeException("더이상 계산할 수 없습니다.");
        }

        return this.score;
    }

    public int getLeft() {
        return this.left;
    }

    private boolean canCalculateScore() {
        return left != NO_LEFT;
    }

    private String printScore() {
        return String.valueOf(score);
    }
}
