package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.pins.Pins;

class PlayedOnce extends Incomplete {
    private final Pins first;

    PlayedOnce(int pins) {
        this.first = Pins.ofFirstBowl(pins);
    }

    @Override
    public Status bowl(int pins) {
        if (first.getPins() + pins == ALL) {
            return new Spare(first.getPins(), pins);
        }
        return new Miss(first.getPins(), pins);
    }

    @Override
    public boolean isPlayed() {
        return true;
    }

    @Override
    public Score createScore() {
        return Score.ofPlayedOnce(first.getPins());
    }

    @Override
    public void updateScore(Score score) {
        score.bowl(first.getPins());
    }

    @Override
    public String toString() {
        return first.toString();
    }
}