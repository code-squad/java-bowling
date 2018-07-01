package bowling.domain.state;

import bowling.domain.MaximumRollExceededException;
import bowling.domain.Pins;

public class Strike implements State {
    private final Pins knockDownsPins;

    Strike(Pins knockDownsPins) {
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
        return true;
    }

    @Override
    public boolean isSpare() {
        return false;
    }
}
