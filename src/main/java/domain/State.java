package domain;

public class State {
    boolean state;

    public State(boolean state) {
        this.state = state;
    }

    public boolean isEnd() {
        return state;
    }
}
