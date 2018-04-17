package status;

import game.Pin;

public class Strike extends Status {
    public Strike(Pin firstPin) {
        super(firstPin);
    }

    public boolean checkStrike() {
        if (super.getFirstPin().checkFinish() && super.getSecondPin() == null) {
            System.out.println("스트라이크");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "X";
    }
}
