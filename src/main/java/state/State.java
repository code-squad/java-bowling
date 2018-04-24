package state;

import domain.Pins;
import domain.Score;

import java.util.Objects;

abstract public class State implements Statable, Cloneable {
    private final boolean state;

    public State(boolean state) {
        this.state = state;
    }

    public boolean isEnd() {
        return state;
    }

    abstract public State bowl(Pins falledPins);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state1 = (State) o;
        return this.getClass().equals(state1.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this);
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return (State) super.clone();
    }

    abstract public Score updateScore(Score beforeScore);
}
