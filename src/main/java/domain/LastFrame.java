package domain;

public class LastFrame extends Frame {
    private BonusScore bonusScore;

    public LastFrame() {
        this.bonusScore = new BonusScore();
    }

    public void updateBonusThrow(int pinsKnocked) {
        bonusScore.updateScore(pinsKnocked);
    }

    @Override
    public String toString() {
        return scores.toString() + bonusScore.toString();
    }
}