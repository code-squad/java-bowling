package bowling.domain;

public class BonusBowl {
    private Integer pinsLeftFromPrevBowl;
    private Integer pinsDownFromThisBowl;

    public boolean isPlayed() {
        return pinsDownFromThisBowl != null;
    }

    public boolean isStrike() {
        return isPlayed() && pinsDownFromThisBowl == 10;
    }

    public boolean isSpare() {
        return isPlayed() && pinsDownFromThisBowl.equals(pinsLeftFromPrevBowl);
    }

    public Integer bowl(int pinsLeftFromPrevBowl, int pinsDownFromThisBowl) {
        if (isPlayed()) {
            this.pinsLeftFromPrevBowl = pinsLeftFromPrevBowl;
            return this.pinsDownFromThisBowl = pinsDownFromThisBowl;
        }
        return null;
    }
}
