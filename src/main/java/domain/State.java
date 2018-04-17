package domain;

abstract public class State implements Statable {
    boolean state;

    public State(boolean state) {
        this.state = state;
    }

    public boolean isEnd() {
        return state;
    }
}
