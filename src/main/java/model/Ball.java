package model;

public class Ball {
    private int pinCount;

    public Ball(int pinCount) {
        if (!isValidInput(pinCount))
            throw new IllegalArgumentException();

        this.pinCount = pinCount;
    }

    private boolean isValidInput(int input) {
        if (input < 0 || input > 10)
            return false;
        return true;
    }

    public int getPinCount() {
        return pinCount;
    }

    @Override
    public String toString() {
        switch(pinCount) {
            case -1:
                return "";
            case 0:
                return "-";
            case 10:
                return "X  ";
            default:
                return Integer.toString(this.pinCount);
        }
    }
}
