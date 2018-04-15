package domain;

import static domain.CalculationDirection.LEFT;

public class LastFrame extends Frame {

    private boolean bonus;

    private LastFrame() {
        super();
    }

    public static Frame of() {
        return new LastFrame();
    }

    @Override
    public void trying(final int score) {
        if (!isValidScore(score))
            throw new IllegalArgumentException("잘못된 입력입니다.");
        if (hasBonusTry()) {
            bonus = true;
            addition(score);
            return;
        }
        addition(score);
    }

    @Override
    public boolean isValidScore(final int score) {
        try {
            return hasBonusTry() || isFirstStrike() || isValidScoreToTotalScore(score);
        } catch (RuntimeException e) {
            return true;
        }
    }

    private boolean hasBonusTry() {
        return isSpare() || (isTrySecond() && isFirstStrike()) ;
    }

    @Override
    protected ScoreCalculator initScoreCalculator() {
        return ScoreCalculator.of(LEFT);
    }

    @Override
    public boolean isFrameEnd() {
        return bonus || isTrySecond() && !isSpare() && !isFirstStrike();
    }

}
