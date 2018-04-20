package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.normal.NormalComplete;
import bowling.domain.frame.status.normal.NormalFrameStatus;

public class Strike extends NormalComplete {

    @Override
    public NormalFrameStatus bowl(int pins) {
        return this;
    }

    @Override
    public Score createScore() {
        return Score.ofStrike();
    }

    @Override
    public int updateScore(Score score) {
        return score.bowl(10);
    }

    @Override
    public boolean isStrike() {
        return true;
    }

    @Override
    public String toString() {
        return "X";
    }
}