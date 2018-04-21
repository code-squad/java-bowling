package bowling.domain.frame.score;

import bowling.domain.frame.status.normal.Status;

public class Score {
    private int score;
    private int count;

    private Score(int score, int count) {
        this.score = score;
        this.count = count;
    }

    public static Score ofStrike() {
        return new Score(10, 2);
    }

    public static Score ofSpare() {
        return new Score(10, 1);
    }

    public static Score ofMiss(int score) {
        return new Score(score, 0);
    }

    public static Score ofNotPlayed() {
        return new Score(0, -1);
    }

    public void bowl(int score) {
        if (count == 2) {
            this.score += score;
            this.count = 1;
        }
        if (count == 1) {
            this.score += score;
            this.count = 0;
        }
        if (count == -1) {

        }
    }

    @Override
    public String toString() {
        if (count == -1) {
            return "";
        }
        return String.valueOf(score);
    }
}