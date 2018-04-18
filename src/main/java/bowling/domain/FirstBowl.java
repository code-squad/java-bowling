package bowling.domain;

public class FirstBowl {
    private Integer pinsDown;

    public Integer bowl(Integer pinsDown) {
        if (!isPlayed()) {
            return this.pinsDown = pinsDown;
        }
        return null;
    }

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