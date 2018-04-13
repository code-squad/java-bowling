package bowling.domain;

public class Score {
    private static final int ALL = 10;
    private Integer pinsKnocked;

    public boolean knockPinsDown(int pins) {
        if (isPlayed()) {
            pinsKnocked = pins;
            return true;
        }
        return false;
    }

    public boolean isPlayed() {
        return pinsKnocked != null;
    }

    public boolean isStrike() {
        return pinsKnocked == ALL;
    }

    public boolean isSpare(int pinsLeft) {
        return pinsLeft == pinsKnocked;
    }
}
