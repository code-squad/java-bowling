package bowling.domain.frame.status.normal;

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
        return Score.ofNotPlayed();
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