package bowling.domain;

import javax.annotation.Nonnull;
import java.util.Objects;

public class DownPinCount {

    public static final DownPinCount STRIKE = new DownPinCount(10);

    private int count;

    private DownPinCount(int count) {
        if(count < 0 || count > 10) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }

    public static DownPinCount of (int count) {
        return new DownPinCount(count);
    }

    public static DownPinCount of (@Nonnull String countStr) {
        return new DownPinCount(Integer.parseInt(countStr.trim()));
    }

    public DownPinCount add(@Nonnull DownPinCount other) {
        return new DownPinCount(count + other.count);
    }

    public boolean isStrike() {
        return count == 10;
    }

    public boolean isSpare(@Nonnull DownPinCount other) {
        return add(other).count == 10;
    }

    public boolean isGutterOrMiss() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DownPinCount)) return false;
        DownPinCount that = (DownPinCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        if (count == 0)
            return "-";
        if (count == 10)
            return "X";
        return String.valueOf(count);
    }
}
