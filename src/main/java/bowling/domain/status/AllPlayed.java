package bowling.domain.status;

import bowling.domain.score.Score;

public class AllPlayed extends Status {
    private final int first;
    private final int second;

    public AllPlayed(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

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
        return false;
    }

    public boolean isPlayedOnce() {
        return false;
    }

    public boolean isAllPlayed() {
        return true;
    }

    public boolean isComplete() {
        return true;
    }

    public Score createScore() {
        return Score.ofNormal(first + second);
    }

    public int getFirstBowl() {
        return first;
    }

    public int getBothBowl() {
        return first + second;
    }
}