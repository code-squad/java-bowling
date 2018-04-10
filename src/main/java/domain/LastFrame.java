package domain;

import static view.ScoreMarker.*;

public class LastFrame extends Frame {
    private Integer thirdThrow;

    public boolean updateFrame(int throwScore) {
        if (isFirstThrow()) {
            firstThrow = throwScore;
            return true;
        }
        if (isSecondThrow() && !isStrike()) {
            secondThrow = throwScore;
            return true;
        }
        if (isStrike() || isSpare()) {
            thirdThrow = throwScore;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isStrike() && thirdThrow == STRIKE) {
            return markStrike()
                    + markSeparator()
                    + markEmpty()
                    + markSeparator()
                    + markStrike();
        }
        if (isStrike()) {
            return markStrike()
                    + markSeparator()
                    + markEmpty()
                    + markBonusNumber(thirdThrow);
        }
        if (isSpare()) {
            return markSpare(firstThrow)
                    + markBonusNumber(thirdThrow);
        }
        return markNumbers(firstThrow, secondThrow)
                + markSeparator();
    }
}