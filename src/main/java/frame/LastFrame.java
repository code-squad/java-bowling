package frame;

import game.Pin;

public class LastFrame {
    private Pin thirdPin;

    public boolean thirdShoot(int pinBall) {
        if (checkStatus().toString() == "X" && checkStatus().toString() == "/") {
            thirdPin = new Pin(pinBall);
            return true;
        }
        return false;
    }

    public Pin getThirdPin() {
        return thirdPin;
    }
}
