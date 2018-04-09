package domain;

import static domain.Figure.SPARE;

public class LastFrame extends Frame {

    private LastFrame() {
        scores = Scores.of();
    }

    public static Frame of() {
        return new LastFrame();
    }

    public boolean isSpareBonus() {
        return scores.isTryThird() && scores.isTotalScoreOverTen();
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
        if (isSpare()) return scores.firstString() + "|" + SPARE;
        if (isSpareBonus()) return scores.firstString() + "|" + SPARE + "|" + scores.thirdString();
        return scores.toString();
    }

}
