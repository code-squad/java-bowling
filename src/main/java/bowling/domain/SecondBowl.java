package bowling.domain;

public class SecondBowl {
    private Integer pinsLeftFromPrevBowl;
    private Integer pinsDownFromThisBowl;

    public Integer bowl(Integer pinsLeftFromPrevBowl, Integer pinsDownFromThisBowl) {
        if (!isPlayed()) {
            this.pinsLeftFromPrevBowl = pinsLeftFromPrevBowl;
            return this.pinsDownFromThisBowl = pinsDownFromThisBowl;
        }
        return null;
    }

    public boolean isPlayed() {
        return pinsDownFromThisBowl != null;
    }

    public boolean isSpare() {
        return isPlayed() && pinsDownFromThisBowl.equals(pinsLeftFromPrevBowl);
    }

    public boolean isStrike() {
        return isPlayed() && pinsLeftFromPrevBowl == null && pinsDownFromThisBowl == 10;
    }

    public int calculatePinsLeft() {
        return pinsLeftFromPrevBowl - pinsDownFromThisBowl;
    }
}