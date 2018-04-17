package domain;

import state.*;

import java.util.ArrayList;
import java.util.List;

public class LastFrame extends Frame {
    private static final int SECOND_STATE = 1;
    private List<State> states = new ArrayList<>();

    State state = new Ready();
    int index;
//    State state1 = new Ready();
//    State state2 = new Ready();
//    State state3 = new Ready();

    public LastFrame(int no) {
        super(no);
    }

    @Override
    public void throwing(int throwing) {
        state = updateStatus(throwing);
        if (FirstBowl.isFirstBowl(state) || Strike.isStrike(state)) {
            states.add(state);
        }
        if (!FirstBowl.isFirstBowl(state)) {
            try {
                states.set(index, state.clone());
                index++;
                state = new Ready();
            } catch (CloneNotSupportedException e) {
                e.getMessage();
            }
        }

    }

    @Override
    public State updateStatus(int throwing) {
        return state.throwing(throwing);
    }

    @Override
    public boolean isEnd() {
        if (Open.isOpen(state)) {
            return true;
        }
        if (states.size() > 1 && Spare.isSpare(states.get(SECOND_STATE))) {
            return true;
        }
        if (states.size() == 3) {
            return true;
        }
        return false;
    }

    @Override
    public String printState() {
        StringBuilder sb = new StringBuilder();
        for (State state : states) {
            sb.append(state.printState());
        }
        return sb.toString();
    }
}
