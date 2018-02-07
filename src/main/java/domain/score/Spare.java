package domain.score;

import java.util.Optional;

public class Spare extends State {

    private final Pin before;

    Spare(Pin before, Pin pin) {
        this.before = before;
        this.pin = pin;
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return getNext().map(n -> n.getScore() + 10);
    }

    @Override
    public PinType getType() {
        return PinType.SPARE;
    }

    @Override
    public String toString() {
        return before.toString() + "|" + "/";
    }
}
