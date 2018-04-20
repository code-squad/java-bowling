package bowling.frame.state;

import bowling.frame.pin.Pins;

public class StateFactory {
    public static State ready() {
        return new Ready();
    }

    public static State firstBowl(final int countOfPin) {
        return ready().bowl(Pins.bowl(countOfPin));
    }
}
