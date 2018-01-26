package domain.score;

import java.util.Optional;

public class Bonus implements State {

    private final State state;

    private final Pin pin;

    Bonus(State state, Pin pin) {
        this.state = state;
        this.pin = pin;
    }

    @Override
    public State bowl(Pin pin) {
        if (state instanceof Strike) {
            return new FinalBonus(this.pin, pin);
        }
        throw new IllegalStateException();
    }

    @Override
    public int getFirstScore() {
        return pin.toInt();
    }

    @Override
    public Optional<Integer> getTotalScore() {
        if (state instanceof Strike) {
            return Optional.empty();
        }
        return Optional.of(pin.toInt());
    }

    @Override
    public String toString() {
        return pin.toString();
    }
}
