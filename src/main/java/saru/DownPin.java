package saru;

import java.util.Objects;

public class DownPin {
    private static final int MAX_PINS = 10;
    private static final int MIN_PINS = 0;

    private int downPin;

    private DownPin(int downPin) {
        if (downPin > MAX_PINS || downPin < MIN_PINS) {
            throw new IllegalArgumentException();
        }

        this.downPin = downPin;
    }

    public static DownPin of(int downPin) {
        return new DownPin(downPin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DownPin downPin1 = (DownPin) o;
        return downPin == downPin1.downPin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(downPin);
    }
}
