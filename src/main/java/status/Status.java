package status;

import game.Pin;

public class Status {
    private Pin firstPin;
    private Pin secondPin;

    public Status(Pin firstPin) {
        this.firstPin = firstPin;
    }

    public Status(Pin firstPin, Pin seoncPin) {
        this.firstPin = firstPin;
        this.secondPin = seoncPin;
    }

    public Pin getSecondPin() {
        return secondPin;
    }

    public Pin getFirstPin() {

        return firstPin;
    }
}
