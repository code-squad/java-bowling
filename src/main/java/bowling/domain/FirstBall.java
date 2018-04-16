package bowling.domain;

import static bowling.domain.Frame.ALL;
import static bowling.domain.Frame.NONE;

public class FirstBall implements Ball {
    private final int firstBowl;

    public FirstBall(int firstBowl) {
        this.firstBowl = firstBowl;
    }

    @Override
    public int getPinsLeft() {
        return ALL - firstBowl;
    }

    @Override
    public String toString() {
        if (firstBowl == ALL)
            return "X";
        if (firstBowl == NONE)
            return "-";
        return String.valueOf(firstBowl);
    }
}
