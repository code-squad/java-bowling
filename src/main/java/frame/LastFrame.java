package frame;

import status.Ready;
import status.State;
import status.Strike;

import java.util.ArrayList;
import java.util.List;

public class LastFrame {
    private State state = new Ready();
    private List<State> states = new ArrayList<>();

    public List<State> bowl(int pin) {
        state = state.bowl(pin);
        states.add(state);
        if (state.isStrike() || state.isSpare()){
            state = new Ready();
            return states;
        }
        return states;
    }

    public List<State> getStates() {
        return states;
    }
}
