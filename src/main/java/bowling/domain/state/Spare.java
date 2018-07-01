package bowling.domain.state;

import bowling.domain.MaximumRollExceededException;
import bowling.domain.Pins;

public class Spare implements State {
    private final Pins knockDownsPins;

    Spare(Pins knockDownsPins) {
        this.knockDownsPins = knockDownsPins;
    }

    @Override
    public State roll(Pins pins) throws MaximumRollExceededException {
        throw new MaximumRollExceededException();
    }

    @Override
    public boolean canRoll() {
        return false;
    }

    @Override
    public int getKnockDownsPins() {
        return knockDownsPins.getKnockDownPins();
    }

    @Override
    public String getScore() {
        return knockDownsPins.getSymbol();
    }

    @Override
    public boolean isStrike() {
        return false;
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}
