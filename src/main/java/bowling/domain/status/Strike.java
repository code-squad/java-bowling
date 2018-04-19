package bowling.domain.status;

import bowling.domain.score.Score;

public class Strike extends Status {

    public Status bowl(int pins) {
        return this;
    }

    public void updateScore(Score score) {
        score.updateScore(10);
    }

    public boolean isNotPlayed() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

    public boolean isStrike() {
        return true;
    }

    public boolean isPlayedOnce() {
        return false;
    }

    public boolean isAllPlayed() {
        return false;
    }
}