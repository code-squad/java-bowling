package status;

import game.Pin;

public class Missing extends Status {

    public Missing(Pin firstPin, Pin seoncPin) {
        super(firstPin, seoncPin);
    }

    public boolean checkMissing() {
        if (super.getFirstPin() != null && super.getSecondPin() != null && (super.getFirstPin().getPinFall() + super.getSecondPin().getPinFall()) != 10) {
            System.out.println("미싱");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "-";
    }
}
