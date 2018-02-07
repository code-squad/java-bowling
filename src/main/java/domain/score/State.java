package domain.score;

import java.util.Optional;

public abstract class State {
    State next;

    Pin pin;

    int left;

    public abstract Optional<Integer> getTotalScore();

    public abstract boolean isFinish();

    public abstract State bowl(Pin pin);

    public int getScore() {
        return pin.toInt();
    }

    public Optional<State> getNext() {
        return Optional.ofNullable(next);
    }

    public boolean isLeft() {
        return left > 0;
    }
}
