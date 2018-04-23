package bowling.domain.frame.last.score;

import bowling.domain.util.Formatter;

public class Score {
    private int accumulativeScore;
    private final int score;
    private final boolean readyForCalc;

    private Score(int score, boolean readyForCalc) {
        this.score = score;
        this.readyForCalc = readyForCalc;
    }

    public static Score ofReady(int score) {
        return new Score(score, true);
    }

    public static Score ofNotReady(int score) {
        return new Score(score, false);
    }

    public void accumulateScore(int accumulative) {
        accumulativeScore = accumulative;
    }

    private int calculateTotal() {
        return accumulativeScore + score;
    }

    @Override
    public String toString() {
        if (readyForCalc) {
            return Formatter.formatFrame(calculateTotal() + "");
        }
        return Formatter.formatFrame("");
    }
}