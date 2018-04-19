package domain;

import java.util.Objects;

public class LastFrame extends Frame {

    private boolean bonus;
    private int count = 0;

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
        assign(score);
        if (hasBonusTry()) {
            addBonus();
        }
        count++;
    }

    private void addBonus() {
        bonus = true;
    }

    @Override
    public boolean isValidScore(final int score) {
        if (count == 0) {
            return true;
        }
        if (count == 1 && bonus) {
            return true;
        }
        if (count == 2) {
            if (isSpare()) return true;
            if (isStrike()) return true;
            return isValidToTotalScore(score, 1);
        }
        return true;
    }

    private boolean hasBonusTry() {
        return isSpare() || isStrike();
    }

    @Override
    public boolean isFrameEnd() {
        try {
            return isOpen() && count == 2 && !bonus || count == 3;
        } catch (RuntimeException e) {
            return false;
        }
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
