package saru;

import java.util.Objects;

public class DownPin {
    private static final int MAX_PINS = 10;
    private static final int MIN_PINS = 0;

    private int downPinCount;

    private DownPin(int downPinCount) {
        if (downPinCount > MAX_PINS || downPinCount < MIN_PINS) {
            throw new IllegalArgumentException();
        }

        this.downPinCount = downPinCount;
    }

    public static DownPin of(int downPinCount) {
        return new DownPin(downPinCount);
    }

    // TODO downPinCount 이 10이 됨에 따른 로직 아직 없음

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DownPin downPin1 = (DownPin) o;
        return downPinCount == downPin1.downPinCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(downPinCount);
    }
}
