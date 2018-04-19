package bowling.domain.status;

import bowling.domain.score.Score;

public class Spare extends Complete {
    private final int first;
    private final int second;

    public Spare(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    public Status bowl(int pins) {
        return this;
    }

    public Score createScore() {
        return Score.ofSpare();
    }

    public int updateScore(Score score) {
        if (score.oneMoreBowlNeeded()) {
            return score.bowl(first);
        }
        return score.bowl(first + second);
    }
}