package domain.score;

import java.util.Optional;

public class Miss extends State {

    private final Pin before;

    Miss(Pin before, Pin pin) {
        super(pin, 0);
        this.before = before;
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.of(getScore() + before.toInt());
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
        return next = Ready.bowl(pin);
    }

    @Override
    public String toString() {
        return before.toString() + "|" + pin.toString();
    }
}
