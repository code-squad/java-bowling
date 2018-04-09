package domain;

import static view.ScoreMarker.*;

public class NormalFrame extends Frame {

    public NormalFrame(int firstThrow, int secondThrow) {
        super(firstThrow, secondThrow);
    }

    @Override
    public String toString() {
        if (isStrike()) {
            return markStrike();
        }
        if (isSpare()) {
            return markSpare(firstThrow);
        }
        return markNumbers(firstThrow, secondThrow);
    }
}
