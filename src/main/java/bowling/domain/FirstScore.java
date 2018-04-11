package bowling.domain;

import static bowling.domain.Scores.NONE;

public class FirstScore extends Score {
    private Integer pinsKnocked;

    @Override
    public int updateScore(int pinsKnocked) {
        this.pinsKnocked = pinsKnocked;
        return this.pinsKnocked;
    }

    @Override
    public boolean isPlayed() {
        return pinsKnocked != null;
    }

    @Override
    public String toString(boolean allPinsDown) {
        if (!isPlayed()) {
            return " ";
        }
        if (allPinsDown) {
            return "X";
        }
        if (pinsKnocked == NONE) {
            return "-";
        }
        return String.valueOf(pinsKnocked);
    }
}