package bowling.domain;

public class Ready extends Status {

    public Status bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new Incomplete(pins);
    }

    public void updateScore(Score score) {
        score.updateScore(0);
    }

    public boolean isReady() {
        return true;
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
        return false;
    }
}