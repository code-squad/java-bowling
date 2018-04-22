package bowling.domain.frame.normal.status;

import bowling.domain.frame.normal.score.Score;

public class Miss extends Complete {
    private final int first;
    private final int second;

    public Miss(int first, int pins) {
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
    public boolean updateScore(Score score) {
        if (score.onlyFirstBowlNeeded()) {
            score.bowl(first);
            return true;
        }
        score.bowl(first);
        score.bowl(second);
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