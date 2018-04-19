package bowling.domain.status;

import bowling.domain.score.Score;

public class NotPlayed extends Status {

    public Status bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new PlayedOnce(pins);
    }

    public void updateScore(Score score) {
        score.updateScore(0);
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
}