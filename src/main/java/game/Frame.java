package game;

public class Frame {
    private Pin firstPin;
    private Pin secondPin;

    public void shoot(int pinFall) {
        if (firstPin == null) {
            firstPin = new Pin(pinFall);
            return;
        }
        secondPin = new Pin(pinFall);
    }

    public boolean finishFrame() {
        if (firstPin.checkFinish())
            return true;
        if (firstPin != null && secondPin != null)
            return true;
        return false;
    }

    public Pin getFirstPin() {
        return firstPin;
    }

    public Pin getSecondPin() {
        return secondPin;
    }
}
