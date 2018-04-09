package domain;

public class NormalFrame implements Frame {
    private final int secondThrow;
    private final int firstThrow;

    public NormalFrame(int firstThrow, int secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    public boolean isStrike() {
        return firstThrow == MAX;
    }

    public boolean isSpare() {
        return firstThrow + secondThrow == MAX;
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
