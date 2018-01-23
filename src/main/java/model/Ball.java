package model;

public class Ball {
    private int pinCount;

    public Ball(int pinCount) {
        checkValidInput(pinCount);

        this.pinCount = pinCount;
    }

    private void checkValidInput(int input) {
        if (input < 0 || input > 10)
            throw new IllegalArgumentException();
    }

    public int getPinCount() {
        return pinCount;
    }

    @Override
    public String toString() {
        switch (pinCount) {
            case 0:
                return "-";
            case 10:
                return "X";
            default:
                return Integer.toString(this.pinCount);
        }
    }
}
