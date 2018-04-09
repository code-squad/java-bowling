package domain;

public class NormalFrame extends Frame {

    public NormalFrame(int firstThrow, int secondThrow) {
        super(firstThrow, secondThrow);
    }

    @Override
    public String toString() {
        if (isStrike()) {
            return ScoreMarker.markStrike();
        }
        if (isSpare()) {
            return ScoreMarker.markSpare(firstThrow);
        }
        return ScoreMarker.markNumbers(firstThrow, secondThrow);
    }
}
