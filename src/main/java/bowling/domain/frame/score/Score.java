package bowling.domain.frame.score;

import bowling.domain.util.Formatter;

public class Score {
    private static final int TWO_BOWLS_AWAY = 2;
    private static final int ONE_BOWL_AWAY = 1;
    private static final int READY_FOR_DISPLAY = 0;
    private static final int MAX = 10;
    private static final int NONE = 0;

    private int score;
    private int count;

    private Score(int score, int count) {
        this.score = score;
        this.count = count;
    }

    public int calculateNewTotal(int total) {
        return total + score;
    }

    public static Score ofStrike() {
        return new Score(MAX, TWO_BOWLS_AWAY);
    }

    public static Score ofSpare() {
        return new Score(MAX, ONE_BOWL_AWAY);
    }

    public static Score ofMiss(int score) {
        return new Score(score, READY_FOR_DISPLAY);
    }

    public static Score ofNotPlayed() {
        return new Score(NONE, -1);
    }

    public static Score ofPlayedOnce(int score) {
        return new Score(score, ONE_BOWL_AWAY);
    }

    public static Score ofBonus(int score) {
        return new Score(score, READY_FOR_DISPLAY);
    }

    public boolean isReadyForDisplay() {
        return count == READY_FOR_DISPLAY;
    }

    public void bowl(int score) {
        if (count != 0) {
            this.score += score;
            count--;
        }
    }

    public String getScore(int total) {
        if (isReadyForDisplay()) {
            return Formatter.formatFrame(total + "");
        }
        return Formatter.formatFrame("");
    }
}