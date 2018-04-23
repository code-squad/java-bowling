package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.pins.Pins;

class Miss extends Complete {
    private final Pins first;
    private final Pins second;

    Miss(int first, int pins) {
        this.first = Pins.ofFirstBowl(first);
        this.second = Pins.ofSecondBowl(first, pins);
    }

    @Override
    public Status bowl(int pins) {
        return this;
    }

    @Override
    public Score createScore() {
        return Score.ofMiss(first.getPins() + second.getPins());
    }

    @Override
    public void updateScore(Score score) {
        if (score.onlyFirstBowlNeeded()) {
            score.bowl(first.getPins());
            return;
        }
        score.bowl(first.getPins());
        score.bowl(second.getPins());
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return false;
    }

    @Override
    public String toString() {
        return first.getPins() + "|" + second.getPins();
    }
}