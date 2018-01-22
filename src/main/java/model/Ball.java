package model;

public class Ball {
    private int pinCount;
    private boolean isPlayed;

    public Ball() {
        this.isPlayed = false;
    }

    public int getPinCount() {
        return pinCount;
    }

    public void setPinCount(int pinCount) {
        this.pinCount = pinCount;
        this.isPlayed = true;
    }

    public boolean isPlayed() {
        return isPlayed;
    }

    @Override
    public String toString() {
        switch(pinCount) {
            case 0:
                return "-";
            case 10:
                return "X";
            default:
                return Integer.toString(this.pinCount);
        }
    }
}
