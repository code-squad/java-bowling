package bowling.domain.status;

import bowling.domain.score.Score;

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
        return Score.ofNormal(first + second);
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
        return first+ "|" + second;
    }
}