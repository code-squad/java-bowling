package domain;

public class FirstThrow {
    private Integer pinsKnocked;

    public int updateScore(int pinsKnocked) {
        this.pinsKnocked = pinsKnocked;
        return this.pinsKnocked;
    }

    public int countPinsStanding() {
        return 10 - pinsKnocked;
    }

    @Override
    public String toString() {
        if (pinsKnocked == null) {
            return " ";
        }
        if (pinsKnocked == 10) {
            return "X";
        }
        return String.valueOf(pinsKnocked);
    }
}
