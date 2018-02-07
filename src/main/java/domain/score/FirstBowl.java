package domain.score;

import java.util.Optional;

public class FirstBowl extends State {

    FirstBowl(Pin pin) {
        this.pin = pin;
    }

    @Override
    public State bowl(Pin p) {
        if (pin.add(p).equals(Pin.TEN)) {
            return next = new Spare(this.pin, p);
        }
        return next = new Miss(this.pin, p);
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.empty();
    }

    @Override
    public PinType getType() {
        return PinType.NOT_FINISH;
    }

    @Override
    public String toString() {
        return pin.toString();
    }
}
