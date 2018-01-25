package bowling.domain.number;

import bowling.util.ScoreAssistance;

import java.util.Objects;

public class Pins {

    private Integer downCount;

    public Pins(Integer downCount) {
        if (ScoreAssistance.isOverMaxPinCount(downCount)) throw new IllegalArgumentException();
        this.downCount = downCount;
    }

    public boolean lessThan(int number) {
        return downCount < number;
    }

    public boolean greaterThan(int number) {
        return downCount > number;
    }

    public boolean equals(int number) {
        return this.downCount == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pins pin = (Pins) o;
        return Objects.equals(downCount, pin.downCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(downCount);
    }
}