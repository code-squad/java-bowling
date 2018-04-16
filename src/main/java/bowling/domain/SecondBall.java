package bowling.domain;

import static bowling.domain.Frame.ALL;
import static bowling.domain.Frame.NONE;

public class SecondBall implements Ball {
    private final int pinsLeftFromFirstBowl;
    private final int secondBowl;

    public SecondBall(int pinsLeftFromFirstBowl, int secondBowl) {
        this.pinsLeftFromFirstBowl = pinsLeftFromFirstBowl;
        this.secondBowl = secondBowl;
    }

    @Override
    public int getPinsLeft() {
        return pinsLeftFromFirstBowl - secondBowl;
    }

    @Override
    public String toString() {
        if (pinsLeftFromFirstBowl - secondBowl == NONE)
            return "/";
        if (secondBowl == NONE)
            return "-";
        return String.valueOf(secondBowl);
    }
}