package domain.score;

import java.util.Optional;

public class FinalBonus implements State, Finish {

    private final Pin before;

    private final Pin pin;

    FinalBonus(Pin before, Pin pin) {
        isValid(before, pin);
        this.before = before;
        this.pin = pin;
    }

    @Override
    public State bowl(Pin pin) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getFirstScore() {
        return before.toInt();
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.of(before.toInt() + pin.toInt());
    }

    private void isValid(Pin before, Pin pin) {
        if (before.isStrike() || pin.isStrike()) {
            return;
        }
        if (before.toInt() + pin.toInt() > 10) {
            throw new IllegalArgumentException();
        }
    }
}
