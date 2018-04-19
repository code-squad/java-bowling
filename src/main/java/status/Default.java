package status;

import game.Pin;

public class Default extends Status {
    public Default() {

    }

    public Default(Pin firstPin) {
        super(firstPin);
    }

    public Default(Pin firstPin, Pin secondPin) {
        super(firstPin, secondPin);
    }

    public Status decision(Pin fir) {
        if (pin == 10)
            return new Strike(new Pin(pin));

    }
}
