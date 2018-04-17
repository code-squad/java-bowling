package frame;

import game.Pin;
import status.Status;

public class Frame {
    private Pin firstPin;
    private Pin secondPin;

    public boolean shoot(int pinFall) {
        if (firstPin == null) {
            firstPin = new Pin(pinFall);
            return true;
        }
        secondPin = new Pin(pinFall);
        return true;
    }

    public boolean finishFrame() {
        if (firstPin.checkFinish())
            return true;
        if (firstPin != null && secondPin != null)
            return true;
        return false;
    }

    public Status checkStatus() {
        if (secondPin == null)
            return new Status(firstPin);
        return new Status(getFirstPin(), getSecondPin());
    }

    public Pin getFirstPin() {
        return firstPin;
    }

    public Pin getSecondPin() {
        return secondPin;
    }
}
