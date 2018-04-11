package domain;

public class FirstScore extends Score {
    private Integer pinsKnocked;

    @Override
    public int updateScore(int pinsKnocked) {
        this.pinsKnocked = pinsKnocked;
        return this.pinsKnocked;
    }

    @Override
    public boolean isNoPinStanding() {
        return pinsKnocked.equals(pinsStanding);
    }

    @Override
    public boolean isPlayed() {
        return pinsKnocked != null;
    }

    @Override
    public String toString() {
        if (!isPlayed()) {
            return " ";
        }
        if (isNoPinStanding()) {
            return "X";
        }
        if (pinsKnocked == 0) {
            return "-";
        }
        return String.valueOf(pinsKnocked);
    }
}