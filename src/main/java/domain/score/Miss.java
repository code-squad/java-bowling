package domain.score;

import java.util.Optional;

public class Miss extends State {

    private final Pin before;

    Miss(Pin before, Pin pin) {
        this.before = before;
        this.pin = pin;
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.of(pin.toInt() + before.toInt());
    }

    @Override
    public PinType getType() {
        return PinType.MISS;
    }

    @Override
    public String toString() {
        return before.toString() + "|" + pin.toString();
    }
}
