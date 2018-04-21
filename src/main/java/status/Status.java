package status;

import game.Pin;

public class Status {
    private Pin firstPin;
    private Pin secondPin;

    public Status(Pin firstPin) {
        this.firstPin = firstPin;
    }

    public Status(Pin firstPin, Pin secondPin) {
        this.firstPin = firstPin;
        this.secondPin = secondPin;
    }

    public Pin getSecondPin() {
        return secondPin;
    }

    public Pin getFirstPin() {
        return firstPin;
    }
}
