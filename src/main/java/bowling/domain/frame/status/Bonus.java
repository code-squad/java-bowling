package bowling.domain.frame.status;

import bowling.domain.frame.score.Score;
import bowling.domain.frame.status.pins.Pins;

public class Bonus extends Complete {
    private final Pins pins;

    public Bonus(int pins) {
        this.pins = Pins.ofFirstBowl(pins);
    }

    @Override
    public Status bowl(int pins) {
        return this;
    }

    @Override
    public boolean isStrike() {
        return pins.getPins() == ALL;
    }

    @Override
    public boolean isSpare() {
        return false;
    }

    @Override
    public boolean isMiss() {
        return false;
    }

    @Override
    public Score createScore() {
//        throw new NoScoreRequiredException();
        return Score.ofBonus(pins.getPins());
    }

    @Override
    public void updateScore(Score score) {
    }

    @Override
    public String toString() {
        if (isStrike()) {
            return "X";
        }
        return pins.getPins() + "";
    }
}
