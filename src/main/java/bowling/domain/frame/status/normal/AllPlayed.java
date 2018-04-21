package bowling.domain.frame.status.normal;

import bowling.domain.frame.score.NormalScore;
import bowling.domain.frame.score.Score;

public class AllPlayed extends Complete {
    private final int first;
    private final int second;

    public AllPlayed(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    @Override
    public Status bowl(int pins) {
        return this;
    }

    @Override
    public Score createScore() {
        return Score.ofMiss(first + second);
    }

    @Override
    public boolean updateScore(NormalScore normalScore) {
        if (normalScore.oneMoreBowlNeeded()) {
            normalScore.bowl(first);
            return true;
        }
        normalScore.bowl(first + second);
        return true;
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public String toString() {
        return first+ "|" + second;
    }
}