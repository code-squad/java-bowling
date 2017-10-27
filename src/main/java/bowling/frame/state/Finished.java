package bowling.frame.state;

import bowling.frame.pin.Pins;

public abstract class Finished implements State {
    @Override
    public State bowl(Pins falledPins) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isFinish() {
        return true;
    }
}
