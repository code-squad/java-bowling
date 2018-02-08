package domain.score;

import java.util.Optional;

public class Spare extends State {

    private final Pin before;

    Spare(Pin before, Pin pin) {
        super(pin, 1);
        this.before = before;
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
        reduceLeft();
        return next = Ready.bowl(pin);
    }

    @Override
    public String toString() {
        return before.toString() + "|" + "/";
    }
}
