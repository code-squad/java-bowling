package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

public class NotPlayed extends Incomplete {

    @Override
    public Status bowl(int pins) {
        if (pins == ALL) {
            return new Strike();
        }
        return new PlayedOnce(pins);
    }

    @Override
    public boolean isPlayed() {
        return false;
    }

    @Override
    public void updateScore(Score score) {
    }

    @Override
    public String toString() {
        return "";
    }
}