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
        if (!bonusScore.isPlayed()) {
            bonusScore.updateScore(pinsKnocked);
        }
    }

    @Override
    public String toString() {
        return scores.toString() + bonusScore.toString();
    }
}