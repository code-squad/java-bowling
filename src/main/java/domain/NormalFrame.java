package domain;

import static view.ScoreMarker.*;

public class NormalFrame extends Frame {

    public boolean updateFrame(int throwScore) {
        if (frameNotPlayed()) {
            firstThrow = throwScore;
            return true;
        }
        if (secondThrowNotPlayed()) {
            secondThrow = throwScore;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (frameNotPlayed()) {
            return markEmpty();
        }
        if (secondThrowNotPlayed()) {
            return markNumber(firstThrow) + markSeparator() + markEmpty();
        }
        if (isStrike()) {
            return markStrike();
        }
        if (isSpare()) {
            return markSpare(firstThrow);
        }
        if (isZero()) {
            return markNone() + markSeparator() + markNone();
        }
        return markNumber(firstThrow) + markSeparator() + markNumber(secondThrow);
    }
}