package bowling.domain.status;

import bowling.domain.score.Score;

public class Spare extends Status {
    private final int first;
    private final int second;

    public Spare(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    public void updateScore(Score score) {
        score.updateScore(10);
    }

    public boolean isReady() {
        return false;
    }

    public Status bowl(int pins) {
        return this;
    }

    public boolean isSpare() {
        return true;
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isIncomplete() {
        return false;
    }

    public boolean isComplete() {
        return false;
    }
}