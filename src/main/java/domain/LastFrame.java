package domain;

public class LastFrame extends Frame {
    private FirstThrow firstThrow;
    private SecondThrow secondThrow;
    private BonusThrow bonusThrow;

    public LastFrame() {
        this.firstThrow = new FirstThrow();
        this.secondThrow = new SecondThrow();
        this.bonusThrow = new BonusThrow();
    }

    public void updateFirstThrow(int pinsKnocked) {
        firstThrow.updateScore(pinsKnocked);
    }

    public void updateSecondThrow(int pinsKnocked) {
        secondThrow.updateScore(firstThrow.countPinsStanding(), pinsKnocked);
    }

    public void updateBonusThrow(int pinsKnocked) {
        bonusThrow.updateScore(pinsKnocked);
    }

    @Override
    public String toString() {
        return firstThrow.toString() + secondThrow.toString() + bonusThrow.toString();
    }
}
