package domain;

import static view.ScoreMarker.*;

public class NormalFrame extends Frame {

    public boolean updateFrame(int throwScore) {
        if (isFirstThrow()) {
            firstThrow = throwScore;
            return true;
        }
        if (isSecondThrow()) {
            secondThrow = throwScore;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isStrike()) {
            return markStrike();
        }
        if (isSpare()) {
            return markSpare(firstThrow);
        }
        if (firstThrow + secondThrow == 0) {
            return markEmpty() + markSeparator() + markEmpty();
        }
        return markNumbers(firstThrow, secondThrow);
    }
}