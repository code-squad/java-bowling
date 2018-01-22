package model;

public interface Frame {
    boolean isFinal();

    void bowl(int number);

    int getPinCount(int index);
}
