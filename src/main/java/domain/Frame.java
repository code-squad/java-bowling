package domain;

public abstract class Frame {
    static final int STRIKE = 10;
    Integer firstThrow;
    Integer secondThrow;

    boolean frameNotPlayed() {
        return firstThrow == null
                && secondThrow == null;
    }

    boolean secondThrowNotPlayed() {
        return firstThrow != null
                && secondThrow == null;
    }

    public boolean isStrike() {
        return firstThrow == STRIKE;
    }

    public boolean isSpare() {
        return firstThrow + secondThrow == STRIKE;
    }

    boolean isZero() {
        return firstThrow + secondThrow == 0;
    }

    public abstract boolean updateFrame(int throwScore);

    public abstract String toString();
}