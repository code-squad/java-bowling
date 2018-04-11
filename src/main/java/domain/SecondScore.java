package domain;

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
    public boolean isPlayed() {
        return pinsKnocked != null;
    }

    @Override
    public String toString(boolean allPinsDown) {
        if (!isPlayed()) {
            return "  ";
        }
        if (allPinsDown) {
            return "|/";
        }
        if (pinsKnocked == 0) {
            return "|-";
        }
        return "|" + pinsKnocked;
    }
}