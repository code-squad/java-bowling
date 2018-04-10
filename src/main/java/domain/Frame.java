package domain;

public abstract class Frame {
    static final int STRIKE = 10;
    Integer firstThrow;
    Integer secondThrow;

    boolean isStrike() {
        return firstThrow == STRIKE;
    }

    boolean isSpare() {
        return firstThrow + secondThrow == STRIKE;
    }

    boolean isFirstThrow() {
        return firstThrow == null
                && secondThrow == null;
    }

    boolean isSecondThrow() {
        return firstThrow != null
                && secondThrow == null;
    }

    public abstract boolean updateFrame(int throwScore);

    public abstract String toString();
}