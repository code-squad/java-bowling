package domain;

import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public class LastFrame extends Frame {

    private LastFrame() {
        scores = Scores.of();
    }

    public static Frame of() {
        return new LastFrame();
    }

    private boolean isSpareBonus() {
        return scores.isTryThird() && scores.isTotalScoreOverTenAndNotDouble();
    }

    @Override
    public boolean isValidScore(int score) {
        return scores.isValidScoreForLastCase(score);
    }

    @Override
    public boolean isFrameEnd() {
        if (scores.isTryThird()) return true;
        if (scores.isTrySecond() && scores.isTotalScoreUnderTen()) return true;
        return false;
    }

    @Override
    public String toString() {
        if (isSpare()) return scores.firstString() + FRAMEBAR + SPARE;
        if (isSpareBonus()) return scores.firstString() + FRAMEBAR + SPARE + FRAMEBAR + scores.thirdString();
        return scores.toString();
    }

}
