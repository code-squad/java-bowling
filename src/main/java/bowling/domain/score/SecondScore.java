package bowling.domain.score;

import static bowling.domain.score.Scores.NONE;

public class SecondScore extends Score {
    private Integer pinsKnocked;

    @Override
    public int updateScore(int pinsKnocked) {
        if (this.pinsKnocked == null) {
            this.pinsKnocked = pinsKnocked;
        }
        return this.pinsKnocked;
    }

    @Override
    public boolean isNotPlayed() {
        return pinsKnocked == null;
    }

    @Override
    public String toString(boolean allPinsDown) {
        if (!isNotPlayed()) {
            return "  ";
        }
        if (allPinsDown) {
            return "|/";
        }
        if (pinsKnocked == NONE) {
            return "|-";
        }
        return "|" + pinsKnocked;
    }
}