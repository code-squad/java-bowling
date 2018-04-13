package saru;

import java.util.Objects;

public class DownPin {
    private int downPinCount;

    private DownPin(int downPinCount) {
        this.downPinCount = downPinCount;
    }

    public static DownPin of(int downPinCount) {
        return new DownPin(downPinCount);
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
}
