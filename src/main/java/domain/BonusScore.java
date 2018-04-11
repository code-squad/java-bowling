package domain;

import static domain.Scores.NONE;

public class BonusScore extends Score {
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
    public String toString(boolean allPinsDown) {
        if (!isPlayed()) {
            return "| ";
        }
        if (allPinsDown) {
            return "|X";
        }
        if (pinsKnocked == NONE) {
            return "|-";
        }
        return "|" + pinsKnocked;
    }
}