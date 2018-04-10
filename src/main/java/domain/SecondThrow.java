package domain;

public class SecondThrow {
    private Integer pinsKnocked;
    private Integer pinsLeftFromPrevThrow;

    public int updateScore(int pinsStanding, int pinsKnocked) {
        this.pinsKnocked = pinsKnocked;
        this.pinsLeftFromPrevThrow = pinsStanding;
        return pinsKnocked;
    }

    public boolean isSpare() {
        return pinsLeftFromPrevThrow - pinsKnocked == 0;
    }

    @Override
    public String toString() {
        if (pinsKnocked == null) {
            return "  ";
        }
        if (isSpare()) {
            return "|/";
        }
        if (pinsKnocked == 0){
            return "|-";
        }
        return "|" + pinsKnocked;
    }
}
