package domain;

public abstract class Frame {
    public static final int MAX = 10;
    final int firstThrow;
    final int secondThrow;

    public Frame(int firstThrow, int secondThrow){
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    public boolean isStrike() {
        return firstThrow == MAX;
    }

    public boolean isSpare() {
        return firstThrow + secondThrow == MAX;
    }

    public abstract String toString();
}
