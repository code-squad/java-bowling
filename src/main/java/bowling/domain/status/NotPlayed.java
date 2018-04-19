package bowling.domain.status;

import bowling.domain.score.Score;

public class NotPlayed extends Status {

    public Status bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new PlayedOnce(pins);
    }

    public boolean isNotPlayed() {
        return true;
    }

    public boolean isSpare() {
        return false;
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isPlayedOnce() {
        return false;
    }

    public boolean isAllPlayed() {
        return false;
    }

    public boolean isComplete() {
        return false;
    }

    public Score createScore() {
        return null;
    }

    public int getFirstBowl() {
        return 0;
    }

    public int getBothBowl() {
        return 0;
    }
}