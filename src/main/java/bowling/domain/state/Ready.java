package bowling.domain.state;

import bowling.domain.MaximumRollExceededException;
import bowling.domain.Pins;

public class Ready implements State {
    @Override
    public State roll(Pins pins) throws MaximumRollExceededException {
        if (pins.isKnockDownAll()) {
            return new Strike(pins);
        }

        return new FirstBowl(pins);
    }

    @Override
    public boolean canRoll() {
        return true;
    }

    @Override
    public int getKnockDownsPins() {
        return 0;
    }

    @Override
    public String getScore() {
        return "";
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return false;
    }
}
