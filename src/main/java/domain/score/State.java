package domain.score;

import java.util.Optional;

public abstract class State {
    final Pin pin;

    State next;

    private int left;

    public State(Pin pin, int left) {
        this.pin = pin;
        this.left = left;
    }

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

    void reduceLeft() {
        if (!isLeft()) {
            throw new IllegalStateException();
        }
        left--;
    }
}
