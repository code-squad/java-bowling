package domain.score;

import java.util.Optional;

public class Spare extends State {

    private final Pin before;

    Spare(Pin before, Pin pin) {
        this.before = before;
        this.pin = pin;
        this.left = 1;
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return getNext().map(n -> n.getScore() + 10);
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public State bowl(Pin pin) {
        if (!isLeft()) {
            throw new IllegalStateException();
        }
        left--;
        return next = Ready.getInstance().bowl(pin);
    }

    @Override
    public String toString() {
        return before.toString() + "|" + "/";
    }
}
