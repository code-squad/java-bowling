package bowling.domain.frame.status;

import bowling.domain.exception.FrameNotPlayedException;
import bowling.domain.frame.score.Score;

public class NotPlayed extends Incomplete {

    @Override
    public Status bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new PlayedOnce(pins);
    }

    @Override
    public Score createScore() {
        return null;
    }

    @Override
    public int updateScore(Score score) {
        throw new FrameNotPlayedException();
    }

    @Override
    public String toString() {
        return " ";
    }
}