package frame;

import game.Pin;
import status.*;

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
            return new Strike(firstPin);

        if ((firstPin.getPinFall() + secondPin.getPinFall() == 10) && firstPin.getPinFall() != Pin.getMaxFall())
            return new Spare(firstPin, secondPin);

        if (secondPin.getPinFall() == 0)
            return new Missing(firstPin, secondPin);

        return new Normal(firstPin, secondPin);
    }

    public Pin getFirstPin() {
        return firstPin;
    }

    public Pin getSecondPin() {
        return secondPin;
    }

    public void getResult() {
        if (getFirstPin().checkFinish())
            System.out.print("  " + checkStatus().toString() + "   ");

        if (!(getFirstPin().checkFinish()))
        System.out.print("  " + getFirstPin().getPinFall() + "|" + checkStatus().toString() + " ");
    }
}
