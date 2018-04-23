package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;

class Spare extends Complete {
    private final int first;
    private final int second;

    Spare(int first, int pins) {
        this.first = first;
        this.second = pins;
    }

    @Override
    public Status bowl(int pins) {
        return this;
    }

    @Override
    public Score createScore() {
        return Score.ofSpare();
    }

    @Override
    public void updateScore(Score score) {
        if (score.onlyFirstBowlNeeded()) {
            score.bowl(first);
            return;
        }
        score.bowl(first);
        score.bowl(second);
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return true;
    }

    @Override
    public String toString() {
        return first + "|/";
    }
}