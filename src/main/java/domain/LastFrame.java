package domain;

import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public class LastFrame extends Frame {

    private LastFrame() {
        super(Scores.of());
    }

    public static Frame of() {
        return new LastFrame();
    }

    @Override
    public boolean isValidScore(int score) {
        return isValidForLastCase(score);
    }

    @Override
    public boolean isFrameEnd() {
        if (isTryThird()) return true;
        if (isaBoolean()) return true;
        return false;
    }


    @Override
    public String toString() {
        if (isSpare()) return getFirstString() + FRAMEBAR + SPARE;
        if (isSpareBonus()) return getFirstString() + FRAMEBAR + SPARE + FRAMEBAR + getThirdString();
        return getScoresString();
    }

}
