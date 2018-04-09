package domain;

import static view.ScoreMarker.*;

public class LastFrame extends Frame {
    private final int thirdThrow;

    public LastFrame(int firstThrow, int secondThrow, int thirdThrow) {
        super(firstThrow, secondThrow);
        this.thirdThrow = thirdThrow;
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
