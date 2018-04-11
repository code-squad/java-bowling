package domain;

public class LastNormalFrame extends Frame {
    private Score bonusScore;

    public LastNormalFrame() {
        this.bonusScore = new BonusScore();
    }

    @Override
    public void updateScore(int pinsKnocked) {
        if (!scores.firstThrowPlayed()) {
            scores.updateFirstThrow(pinsKnocked);
        }
        if (!scores.secondThrowPlayed()) {
            scores.updateSecondThrow(pinsKnocked);
        }
        if()
    }

    public void updateBonusThrow(int pinsKnocked) {
        bonusScore.updateScore(pinsKnocked);
    }

    @Override
    public void updateScores(int pinsKnocked) {

    }

    @Override
    public String toString() {
        return scores.toString() + bonusScore.toString();
    }
}