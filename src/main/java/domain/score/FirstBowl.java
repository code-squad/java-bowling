package domain.score;

import java.util.Optional;

public class FirstBowl extends State {

    FirstBowl(Pin pin) {
        super(pin, 1);
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.empty();
    }

    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public State bowl(Pin p) {
        reduceLeft();
        if (pin.add(p).equals(Pin.TEN)) {
            return next = new Spare(this.pin, p);
        }
        return next = new Miss(this.pin, p);
    }

    @Override
    public String toString() {
        return pin.toString();
    }
}
