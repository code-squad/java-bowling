package bowling.domain;

public class FirstBowl {
    private static final int ALL = 10;
    private final SecondBowl secondBowl = new SecondBowl();
    private Integer pinsDown;

    public boolean firstIsPlayed() {
        return pinsDown != null;
    }

    public boolean secondIsPlayed() {
        return secondBowl.isPlayed();
    }

    public boolean isStrike() {
        return pinsDown == ALL;
    }

    public boolean isSpare() {
        return secondBowl.isSpare();
    }

    public Integer updateBowl(int pinsDown) {
        if (!firstIsPlayed()) {
            return this.pinsDown = pinsDown;
        }
        return secondBowl.updateBowl(ALL - pinsDown, pinsDown);
    }


}