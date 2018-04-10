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
    public void trying(int score) {
        if (!isValidScore(score))
            throw new IllegalArgumentException("잘못된 입력입니다.");
        addition(score);
        if (hasBonusTry())
            lastScore = Score.of(score);
    }

    private boolean hasBonusTry() {
        return isSpare() || isTen();
    }

    @Override
    public boolean isValidScore(int score) {
        boolean result = true;
        if (!isTrySecond() && isTen()) {
            result = true;
        }
        if (!isTrySecond() && !isTen()) {
            result = isValidScoreToTotalScore(score);
        }
        return result;
    }

    @Override
    public boolean isFrameEnd() {
        if (hasBonusTry()) return true;
        if (isTrySecond() && !isSpare()) return true;
        return false;
    }

    @Override
    public String toString() {
        if (isSpare()) return spareString();
        if (isSpare() && hasBonusTry()) return spareString() + FRAMEBAR + lastScore;
        return toScoreString();
    }

}
