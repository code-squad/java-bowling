package bowling.domain.frame;

import bowling.domain.score.BonusScore;

public class LastFrame extends Frame {
    private BonusScore bonusScore = new BonusScore();

    @Override
    public boolean updateScore(int pinsKnocked) {
        if (scores.firstThrowIsNotPlayed()) {
            scores.updateFirstThrow(pinsKnocked);
            return true;
        }
        if (scores.secondThrowIsNotPlayed() && !scores.isStrike()) {
            scores.updateSecondThrow(pinsKnocked);
            return true;
        }
        if (bonusScore.isNotPlayed()) {
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