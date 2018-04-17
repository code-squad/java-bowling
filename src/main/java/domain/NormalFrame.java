package domain;

import state.*;

public class NormalFrame extends Frame {
    State state = new Ready();

    public NormalFrame(int no) {
        super(no);
    }

    public void throwing(int throwing) {
        state = updateStatus(throwing);
    }

    public State updateStatus(int throwing) {
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
