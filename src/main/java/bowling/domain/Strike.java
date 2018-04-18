package bowling.domain;

public class Strike extends Status {

    public Status bowl(int pins) {
        return this;
    }

    public void updateScore(Score score) {
        score.updateScore(10);
    }

    public boolean isReady() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

    public boolean isStrike() {
        return true;
    }

    public boolean isIncomplete() {
        return false;
    }

    public boolean isComplete() {
        return false;
    }
}