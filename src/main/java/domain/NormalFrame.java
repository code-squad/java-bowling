package domain;

public class NormalFrame {
    private final int firstThrow;
    private final int secondThrow;

    public NormalFrame(int firstThrow, int secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    public boolean isStrike() {
        return firstThrow == 10;
    }

    public boolean isSpare() {
        return firstThrow + secondThrow == 10;
    }

    public boolean isNormal() {
        return firstThrow + secondThrow < 10;
    }
}
