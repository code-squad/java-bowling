package model;

public class Shoot {
    private int fallenPinCount;

    public Shoot(int pinCount) {
        checkValidInput(pinCount);

        this.fallenPinCount = pinCount;
    }

    private void checkValidInput(int input) {
        if (input < Pin.MIN_COUNT || input > Pin.MAX_COUNT)
            throw new IllegalArgumentException();
    }

    public int getFallenPinCount() {
        return fallenPinCount;
    }

    @Override
    public String toString() {
        switch (fallenPinCount) {
            case Pin.MIN_COUNT:
                return "-";
            case Pin.MAX_COUNT:
                return "X";
            default:
                return Integer.toString(this.fallenPinCount);
        }
    }
}
