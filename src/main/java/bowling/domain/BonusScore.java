package bowling.domain;

import static bowling.domain.Scores.ALL;
import static bowling.domain.Scores.NONE;

public class BonusScore {
    private Integer pinsKnocked;

    public int updateScore(int pinsKnocked) {
        if (this.pinsKnocked == null) {
            this.pinsKnocked = pinsKnocked;
        }
        return this.pinsKnocked;
    }

    public boolean isPlayed() {
        return pinsKnocked != null;
    }

    @Override
    public String toString() {
        if (!isPlayed()) {
            return "  ";
        }
        if (pinsKnocked == ALL) {
            return "|X";
        }
        if (pinsKnocked == NONE) {
            return "|-";
        }
        return "|" + pinsKnocked;
    }
}