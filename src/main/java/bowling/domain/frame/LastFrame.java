package bowling.domain.frame;

import bowling.domain.score.BonusScore;
import bowling.domain.score.Scores;

public class LastFrame implements Frame{
    private Scores scores = new Scores();
    private BonusScore bonusScore = new BonusScore();

    public boolean updateScore(int pinsKnocked) {
        if (!scores.firstThrowIsPlayed()) {
            scores.updateFirstThrow(pinsKnocked);
            return true;
        }
        if (!scores.secondThrowIsPlayed() && !scores.isStrike()) {
            scores.updateSecondThrow(pinsKnocked);
            return true;
        }
        if (!bonusScore.isPlayed()) {
            bonusScore.updateScore(pinsKnocked);
            return true;
        }
        return false;
    }

    public boolean isStrike() {
        return scores.isStrike();
    }

    public boolean isSpare() {
        return scores.isSpare();
    }

    @Override
    public String toString() {
        return " " + scores.toString() + bonusScore.toString();
    }
}