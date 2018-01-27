package domain.score;

import java.util.Optional;

public class Miss implements State {

    private final Pin first;

    private final Pin second;

    Miss(Pin first, Pin second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public State bowl(Pin pin) {
        throw new IllegalArgumentException();
    }

    @Override
    public int getFirstScore() {
        return first.toInt();
    }

    @Override
    public Optional<Integer> getTotalScore() {
        return Optional.of(second.toInt() + first.toInt());
    }

    @Override
    public PinType getType() {
        return PinType.MISS;
    }

    @Override
    public String toString() {
        return first.toString() + "|" + second.toString();
    }
}
