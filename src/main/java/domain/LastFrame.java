package domain;

import state.*;

import java.util.ArrayList;
import java.util.List;

public class LastFrame extends Frame {
    private static final int FIRST_STATE = 0;
    private static final int MAX = 3;

    private List<State> states = new ArrayList<>();
    private State state = new Ready();
    private int index;
    private Score score;

    public LastFrame(int no, Score beforeScore) {
        super(no, beforeScore);
    }

    @Override
    public void throwing(int throwing) {
        state = updateState(throwing);
        if (FirstBowl.isFirstBowl(state) || Strike.isStrike(state)) {
            states.add(state);
            return;
        }
        try {
            states.set(index, state.clone());
            index++;
            if (!Open.isOpen(state)) {
                state = new Ready();
            }
        } catch (CloneNotSupportedException e) {
            e.getMessage();
        }
    }

    @Override
    public State updateState(int throwing) {
        return state.throwing(throwing);
    }

    @Override
    public boolean isEnd() {
        if (Open.isOpen(state) || states.size() == MAX) {
            return true;
        }
        if (Spare.isSpare(states.get(FIRST_STATE)) && states.size() == 2) {
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

    @Override
    public String printScore() {
        return null;
    }

    @Override
    public Score createScore() {
        return null;
    }
}
