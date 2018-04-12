package domain;

import static domain.Figure.FRAMEBAR;

public class LastFrame extends Frame {

    private Score lastScore;

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
            lastScore = Score.of(score);
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

    private String toStringLastScore() {
        if (lastScore != null) return lastScore.toString();
        return "";
    }

    @Override
    public boolean isFrameEnd() {
        return lastScore != null || isTrySecond() && !isSpare() && !isFirstStrike();
    }

    @Override
    public boolean isCalculateUntilNow() {
        return isFrameEnd();
    }

    @Override
    public String toString() {
        return toFrameString() + FRAMEBAR + toStringLastScore();
    }

}
