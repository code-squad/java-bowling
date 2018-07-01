package bowling.domain.state;

import bowling.domain.MaximumRollExceededException;
import bowling.domain.Pins;

public class FirstBowl implements State {
    private final Pins knockDownsPins;

    FirstBowl(Pins knockDownsPins) {
        this.knockDownsPins = knockDownsPins;
    }

    @Override
    public State roll(Pins pins) throws MaximumRollExceededException {
        knockDownsPins.knockDown(pins);

        if (knockDownsPins.isKnockDownAll()) {
            return new Spare(knockDownsPins);
        }

        return new Miss(knockDownsPins);
    }

    @Override
    public boolean canRoll() {
        return true;
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
        return false;
    }
}
