package domain.score;

import java.util.Optional;

public class Miss extends State {

    private final Pin before;

    Miss(Pin before, Pin pin) {
        this.before = before;
        this.pin = pin;
        this.left = 0;
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.of(pin.toInt() + before.toInt());
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public State bowl(Pin pin) {
        if (getNext().isPresent()) {
            throw new IllegalStateException();
        }
        return next = Ready.getInstance().bowl(pin);
    }

    @Override
    public String toString() {
        return before.toString() + "|" + pin.toString();
    }
}
