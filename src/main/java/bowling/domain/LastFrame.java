package bowling.domain;

public class LastFrame extends Frame {
    private BonusScore bonusScore;

    public LastFrame() {
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
        return " " + scores.toString() + bonusScore.toString();
    }
}