package domain.score;

import java.util.Optional;

public class Strike implements State, Finish {
    @Override
    public State bowl(Pin pin) {
        throw new IllegalStateException();
    }

    @Override
    public int getFirstScore() {
        return 10;
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.of(10);
    }

    @Override
    public PinType getType() {
        return PinType.STRIKE;
    }

    @Override
    public String toString() {
        return "X";
    }
}
