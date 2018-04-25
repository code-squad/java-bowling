package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.pins.Pins;

class Spare extends Complete {
    private final Pins first;
    private final Pins second;

    Spare(int first, int pins) {
        this.first = Pins.ofFirstBowl(first);
        this.second = Pins.ofSecondBowl(first, pins);
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
        if (score.isOneBowlAway()) {
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
        return true;
    }

    @Override
    public boolean isMiss() {
        return false;
    }

    @Override
    public String toString() {
        return first.toString() + "|/";
    }
}