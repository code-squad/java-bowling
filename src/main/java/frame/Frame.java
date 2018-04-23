package frame;

import status.Ready;
import status.State;

public class Frame {
    public State state = new Ready();

    public State bowl(int pin) {
        state = state.bowl(pin);
        return state;
    }
}
