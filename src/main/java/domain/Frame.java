package domain;

public abstract class Frame {
    public static final int STRIKE
            = 10;
    final int firstThrow;
    final int secondThrow;

    public Frame(int firstThrow, int secondThrow){
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    public boolean isStrike() {
        return firstThrow == STRIKE;
    }

    public boolean isSpare() {
        return firstThrow + secondThrow == STRIKE;
    }

    public abstract String toString();
}
