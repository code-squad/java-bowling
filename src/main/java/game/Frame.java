package game;

public class Frame {
    private Pin firstPin;
    private Pin secondPin;

    public void shootFirstPin(int shootpin) {
        firstPin = new Pin(shootpin);
        shootSecondPin(shootpin);
    }

    public void shootSecondPin(int shootPin) {
        secondPin = new Pin(shootPin);

    }

    public boolean finishFrame() {
        if (firstPin.getPinFall() >= Pin.getMinFall() && firstPin.checkFinish())
            return true;

        if (firstPin.getPinFall() >= Pin.getMinFall() && secondPin.getPinFall() >= Pin.getMinFall())
            return true;
        return false;
    }
}
