package bowling.domain;

import static bowling.domain.Frame.ALL;

public class BonusBall implements Ball {
    private final int pinsLeftFromSecondBowl;
    private final int bonusBowl;

    public BonusBall(int pinsLeftFromSecondBowl, int bonusBowl) {
        this.pinsLeftFromSecondBowl = pinsLeftFromSecondBowl;
        this.bonusBowl = bonusBowl;
    }

    @Override
    public int getPinsLeft() {
        return pinsLeftFromSecondBowl - bonusBowl;
    }

    @Override
    public String toString() {
        if (bonusBowl == ALL)
            return "X";
        if (pinsLeftFromSecondBowl == bonusBowl)
            return "/";
        return String.valueOf(bonusBowl);
    }
}