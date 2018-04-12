package bowling.domain;

public class LastFrame extends Frame {
    private BonusScore bonusScore = new BonusScore();

    @Override
    public boolean updateScore(int pinsKnocked) {
        if (!scores.firstThrowPlayed()) {
            scores.updateFirstThrow(pinsKnocked);
            return true;
        }
        if (!scores.secondThrowPlayed()) {
            scores.updateSecondThrow(pinsKnocked);
            return true;
        }
        if (!bonusScore.isPlayed()) {
            bonusScore.updateScore(pinsKnocked);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return " " + scores.toString() + bonusScore.toString();
    }
}