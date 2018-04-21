package bowling.domain.frame.score;

public class Score {
    private int score;
    public int count;

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

    public static Score ofPlayedOnce(int score) {
        return new Score(score, 1);
    }

    public boolean bowl(int score) {
        if (count != 0) {
            this.score += score;
            count--;
            return true;
        }
        return false;
    }

    public boolean onlyFirstBowlNeeded() {
        return count == 1;
    }

    public boolean twoMoreBowlsNeeded() {
        return count == 2;
    }

    public void updateLastFrameScore(int score) {
        this.score += score;
    }

    @Override
    public String toString() {
        if (count != 0) {
            return "";
        }
        return String.valueOf(score);
    }
}