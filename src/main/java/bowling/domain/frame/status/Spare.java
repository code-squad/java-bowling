package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.normal.NormalComplete;
import bowling.domain.frame.status.normal.NormalFrameStatus;

public class Spare extends NormalComplete {
    private final int first;
    private final int second;

    public Spare(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    @Override
    public NormalFrameStatus bowl(int pins) {
        return this;
    }

    @Override
    public Score createScore() {
        return Score.ofSpare();
    }

    @Override
    public int updateScore(Score score) {
        if (score.oneMoreBowlNeeded()) {
            return score.bowl(first);
        }
        return score.bowl(first + second);
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public String toString() {
        return first + "|/";
    }
}