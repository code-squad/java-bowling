package bowling.domain.status;

import bowling.domain.score.Score;

public class Strike extends Status {

    public Status bowl(int pins) {
        return this;
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

    public boolean isComplete() {
        return true;
    }

    public Score createScore() {
        return Score.ofStrike();
    }

    public int getFirstBowl() {
        return 10;
    }

    public int getBothBowl() {
        return 10;
    }
}