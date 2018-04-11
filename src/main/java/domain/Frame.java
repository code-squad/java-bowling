package domain;

public abstract class Frame {

    public abstract void updateFirstThrow(int pinsKnocked);

    public abstract void updateSecondThrow(int pinsKnocked);

    @Override
    public abstract String toString();
}
