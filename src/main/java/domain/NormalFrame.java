package domain;

import state.*;

public class NormalFrame extends Frame {
    private State state = new Ready();

    public NormalFrame(int no) {
        super(no);
    }

    public void throwing(int throwing) {
        state = updateState(throwing);
    }

    public State updateState(int throwing) {
        return state.throwing(throwing);
    }

    @Override
    public boolean isEnd() {
        return state.isEnd();
    }

    @Override
    public String printState() {
        return state.printState();
    }
}
