package bowling.domain.status;

import bowling.domain.score.Score;

public class Incomplete extends Status {
    private final int first;

    public Incomplete(int pins) {
        this.first = pins;
    }

    @Override
    public Status bowl(int pins) {
        if (first + pins == 10) {
            return new Spare(first, pins);
        }
        return new Complete(first, pins);
    }

    public boolean isReady() {
        return false;
    }

    public void updateScore(Score score) {
        score.updateScore(first);
    }

    public boolean isSpare() {
        return false;
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isIncomplete() {
        return true;
    }

    public boolean isComplete() {
        return false;
    }
}