package domain.score;

import java.util.Optional;

public class FirstBowl implements State {

    private final Pin pin;

    FirstBowl(Pin pin) {
        this.pin = pin;
    }

    @Override
    public State bowl(Pin p) {
        if (pin.add(p).equals(Pin.TEN)) {
            return new Spare(this.pin, p);
        }
        return new Miss(this.pin, p);
    }

    @Override
    public int getFirstScore() {
        return pin.toInt();
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return pin.toString();
    }
}
