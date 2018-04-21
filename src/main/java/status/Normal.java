package status;

import game.Pin;

public class Normal extends Status {
    public Normal(Pin firstPin, Pin secondPin) {
        super(firstPin, secondPin);
    }

    public Boolean checkNormal() {
        if (getFirstPin() != null && getSecondPin() != null && getFirstPin().getPinFall() != Pin.getMaxFall() && (getFirstPin().getPinFall() + getSecondPin().getPinFall()) != 10 && getSecondPin().getPinFall() != 0) {
            System.out.println("노말");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(getSecondPin().getPinFall()) + " ";
    }
}
