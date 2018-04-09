package domain;

public interface Frame {
    public static final int MAX = 10;

    public abstract boolean isStrike();

    public abstract boolean isSpare();

    public abstract String toString();
}
