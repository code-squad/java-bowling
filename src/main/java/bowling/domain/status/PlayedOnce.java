package bowling.domain.status;

import bowling.domain.score.Score;

public class PlayedOnce extends Status {
    private final int first;

    public PlayedOnce(int pins) {
        this.first = pins;
    }

    @Override
    public Status bowl(int pins) {
        if (first + pins == 10) {
            return new Spare(first, pins);
        }
        return new AllPlayed(first, pins);
    }

    public boolean isNotPlayed() {
        return false;
    }

    public boolean isSpare() {
        return false;
    }

    public boolean isStrike() {
        return false;
    }

    public boolean isPlayedOnce() {
        return true;
    }

    public boolean isAllPlayed() {
        return false;
    }

    public boolean isComplete() {
        return false;
    }

    public Score createScore() {
        return Score.ofNormal(first);
    }

    public int getFirstBowl() {
        return first;
    }

    public int getBothBowl() {
        return first;
    }
}