package frame;

import input.Input;
import status.Ready;
import status.State;

import java.util.List;

public class LastFrame {
    public State state;

    public State bowl(int pin) {
        state = state.bowl(pin);
        return state;
    }
}
