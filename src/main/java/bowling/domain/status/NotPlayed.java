package bowling.domain.status;

import bowling.domain.score.Score;

public class NotPlayed extends Incomplete {

    public Status bowl(int pins) {
        if (pins == 10) {
            return new Strike();
        }
        return new PlayedOnce(pins);
    }

    public Score createScore() {
        return null;
    }

    public int updateScore(Score score) {
        throw new FrameNotPlayedException();
    }
}