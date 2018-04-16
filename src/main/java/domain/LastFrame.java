package domain;

import java.util.Objects;

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
            addBonus(score);
            return;
        }
        addition(score);
    }

    private void addBonus(int score) {
        if(!isValidBonusScore(score)) {
            throw new IllegalArgumentException("10, 8, 10 이런 점수는 안됩니다. 10, 8 쳤으면 남은 핀 갯수는 2개입니다.");
        }
        bonus = true;
        addition(score);
    }

    private boolean isValidBonusScore(int score) {
        if (isStrike(1)) return true;
        return isValidScoreToTotalScore(score, 1);
    }

    @Override
    public boolean isValidScore(final int score) {
        try {
            return hasBonusTry() || isStrike(0) || isValidScoreToTotalScore(score, 0);
        } catch (RuntimeException e) {
            return true;
        }
    }

    private boolean hasBonusTry() {
        return isSpare() || (isTrySecond() && isStrike(0)) ;
    }

    @Override
    public boolean isFrameEnd() {
        return bonus || isTrySecond() && !isSpare() && !isStrike(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastFrame lastFrame = (LastFrame) o;
        return bonus == lastFrame.bonus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(bonus);
    }
}
