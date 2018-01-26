package domain.score;

import java.util.Optional;

public class Bonus implements State {

    private final State state;

    private final Pin first;

    private Pin second;

    public Bonus(State state, Pin first) {
        if (state instanceof Miss) {
            throw new IllegalArgumentException();
        }
        this.state = state;
        this.first = first;
    }

    @Override
    public State bowl(Pin pin) {
        if (state instanceof Strike && second == null) {
            second = pin;
            if (!first.isStrike()) {
                first.add(second);
            }
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public int getFirstScore() {
        return first.toInt();
    }

    @Override
    public Optional<Integer> getTotalScore() {
        if (state instanceof Strike && second == null) {
            return Optional.empty();
        }
        if (second != null) {
            return Optional.of(first.toInt() + second.toInt());
        }
        return Optional.of(first.toInt());
    }

    @Override
    public String toString() {
        if (second != null) {
            return first.toString() + "|" + second.toString();
        }
        return first.toString();
    }
}
