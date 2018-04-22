package frame;

import game.Pin;
import status.*;

public class LastFrame {
    private Pin firstPin;
    private Pin secondPin;
    private Pin thridPin;

    public Status shoot(int pinFall) {
        if (firstPin == null) {
            firstPin = new Pin(pinFall);
            return new Default(firstPin);
        }
        secondPin = new Pin(pinFall);

        if (firstPin.getPinFall() == 10) {
            thridPin = new Pin(pinFall);
        }

        if (firstPin.getPinFall() != 10 && (firstPin.getPinFall() + secondPin.getPinFall() == 10)) {
            thridPin = new Pin(pinFall);
        }
        return checkStatus();
    }

    public Status checkStatus() {
        if (firstPin.getPinFall() != Pin.getMaxFall() && secondPin == null)
            return new Default(firstPin);

        if (firstPin.getPinFall() == Pin.getMaxFall() && secondPin == null)
            return new Strike(firstPin);

        if ((firstPin.getPinFall() + secondPin.getPinFall() == 10) && firstPin.getPinFall() != Pin.getMaxFall())
            return new Spare(firstPin, secondPin);

        if (secondPin.getPinFall() == 0)
            return new Missing(firstPin, secondPin);

        return new Normal(firstPin, secondPin);
    }

}
