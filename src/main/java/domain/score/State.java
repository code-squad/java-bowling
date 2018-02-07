package domain.score;

import java.util.Optional;

public abstract class State {
    State next;

    Pin pin;

    public abstract Optional<Integer> getTotalScore();

    public abstract PinType getType();

    public int getScore() {
        return pin.toInt();
    }

    public State bowl(Pin pin) {
        return next = Ready.getInstance().bowl(pin);
    }

    Optional<State> getNext() {
        return Optional.ofNullable(next);
    }

}
