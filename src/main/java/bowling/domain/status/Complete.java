package bowling.domain.status;

import bowling.domain.score.Score;

public class Complete extends Status {
    private final int first;
    private final int second;

    public Complete(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    public Status bowl(int pins) {
        return this;
    }

    public void updateScore(Score score) {
        score.updateScore(first + second);
    }

    public boolean isReady() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isIncomplete() {
        return false;
    }

    public boolean isComplete() {
        return true;
    }
}