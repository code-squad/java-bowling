package bowling.domain;

public class SecondBowl {
    private Integer pinsDown;
    private Integer pinsLeftFromPrevBowl;

    public Integer updateBowl(int pinsLeftFromPrevBowl, int pinsDown) {
        if (!isPlayed()) {
            this.pinsLeftFromPrevBowl = pinsLeftFromPrevBowl;
            return this.pinsDown = pinsDown;
        }
        return null;
    }

    public boolean isPlayed() {
        return pinsDown != null;
    }

    public boolean isSpare() {
        return pinsDown.equals(pinsLeftFromPrevBowl);
    }

}
