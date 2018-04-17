package frame;

import game.Pin;

public class LastFrame extends Frame {
    private Pin thirdPin;

    public boolean shoot(int pinFall) {
        if (getFirstPin() != null && getSecondPin().checkFinish()) {
            thirdPin = new Pin(pinFall);
            return true;
        }
        return false;
    }
}
