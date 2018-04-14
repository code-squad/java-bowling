package game;

public class Frame {
    private Pin firstPin;
    private Pin secondPin;

    public void shootFirstPin(int shootpin) {
        if (firstPin == null) {
            firstPin = new Pin(shootpin);
        }
        shootSecondPin(shootpin);
    }

    public void shootSecondPin(int shootPin) {
        if (secondPin == null) {
            secondPin = new Pin(shootPin);
        }
    }

    public boolean finishFrame() {
        if (firstPin != null && firstPin.checkFinish())
            return true;
        if (firstPin != null && secondPin != null)
            return true;
        return false;
    }
}
