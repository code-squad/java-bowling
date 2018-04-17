package status;

import game.Pin;

public class Spare extends Status {
    public Spare(Pin firstPin, Pin secondPin) {
        super(firstPin, secondPin);
    }

    public boolean spareCheck() {
        if (super.getFirstPin().getPinFall() != Pin.getMaxFall() && (super.getFirstPin().getPinFall() + super.getSecondPin().getPinFall() == 10)) {
            System.out.println("스페어");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "/";
    }
}
