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

    public void updateScore(Score score) {
        score.updateScore(first);
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
}