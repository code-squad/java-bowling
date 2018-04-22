package bowling.domain.frame.normal.status;

import bowling.domain.frame.normal.score.Score;

public class NotPlayed extends Incomplete {

    @Override
    public Status bowl(int pins) {
        if (pins == ALL) {
            return new Strike();
        }
        return new PlayedOnce(pins);
    }

    @Override
    public boolean updateScore(Score score) {
        return false;
    }

    @Override
    public String toString() {
        return " ";
    }
}