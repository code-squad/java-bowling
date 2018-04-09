package domain;

import static domain.Figure.SPARE;
import static domain.Figure.STRIKE;

public class LastFrame extends Frame {

    private LastFrame() {
        scores = Scores.of();
    }

    public static Frame of() {
        return new LastFrame();
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
        if (isSpare()) return scores.firstString() + "|"+SPARE;
        if (isStrike()) return STRIKE.toString();
        if (isDouble()) return STRIKE.toString() + "|" + STRIKE.toString();
        if (isTurkey()) return STRIKE.toString() + "|" + STRIKE.toString()+ "|" + STRIKE.toString();
        return scores.toString();
    }

    private boolean isDouble() {
        return scores.isTrySecond() && scores.isTwenty();
    }

    private boolean isTurkey() {
        return scores.isTryThird() && scores.isThirty();
    }

}
