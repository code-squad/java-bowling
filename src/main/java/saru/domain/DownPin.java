package saru.domain;

import java.util.Objects;

public class DownPin {
    private static final int MAX_DOWN_PIN = 10;
    private int downPinCount;

    private DownPin(int downPinCount) {
        this.downPinCount = downPinCount;
    }

    public static DownPin of(int downPinCount) {
        if (downPinCount < 0 || downPinCount > MAX_DOWN_PIN) {
            throw new IllegalArgumentException("DownPin 생성 에러");
        }

        return new DownPin(downPinCount);
    }

    int addWith(DownPin downPin) {
        return this.downPinCount + downPin.downPinCount;
    }

    int getDownPinCount() {
        return downPinCount;
    }

    boolean checkStrike() {
        return downPinCount == MAX_DOWN_PIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DownPin downPin = (DownPin) o;
        return downPinCount == downPin.downPinCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(downPinCount);
    }

    @Override
    public String toString() {
        return String.format("%s", downPinCount);
        // join
    }
}
