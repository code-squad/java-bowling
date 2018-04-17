package bowling.domain;

public class FirstBowl {
    private Integer pinsDown;

    public boolean isPlayed() {
        return pinsDown != null;
    }

    public boolean isStrike() {
        return isPlayed() && pinsDown == 10;
    }

    public int calculatePinsLeft() {
        return 10 - pinsDown;
    }
}