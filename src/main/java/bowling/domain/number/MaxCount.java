package bowling.domain.number;

import bowling.util.ScoreAssistance;

import java.util.Objects;

public class MaxCount {
    private Integer maxPinCount;

    public MaxCount(Integer maxPinCount) {
        if (ScoreAssistance.isOverMaxPinCount(maxPinCount)) throw new IllegalArgumentException();
        this.maxPinCount = maxPinCount;
    }

    public Integer toInteger() {
        return maxPinCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxCount maxCount = (MaxCount) o;
        return Objects.equals(maxPinCount, maxCount.maxPinCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(maxPinCount);
    }

    @Override
    public String toString() {
        return String.valueOf(maxPinCount);
    }
}