package domain;

public class BonusScore {
    private Integer pinsKnocked;

    public int updateScore(int pinsKnocked) {
        if (this.pinsKnocked == null) {
            this.pinsKnocked = pinsKnocked;
        }
        return this.pinsKnocked;
    }

    @Override
    public String toString() {
        if (pinsKnocked == null) {
            return "| ";
        }
        if (pinsKnocked == 10) {
            return "|X";
        }
        if (pinsKnocked == 0) {
            return "|-";
        }
        return "|" + pinsKnocked;
    }
}