package bowling.domain;

import java.util.Optional;

public class Try {
    private int downCount;

    public Try(int downCount) {
        validate(downCount);
        this.downCount = downCount;
    }

    public static Try empty() {
        return new Try(0);
    }

    private void validate(int downCount) {
        if (downCount < 0 || downCount > BowlingConstants.PIN_COUNT) {
            throw new IllegalArgumentException("downCount is not valid, downCount=" + downCount);
        }
    }

    public void validate(Try otherTry) {
        validate(otherTry.downCount + this.downCount);
    }

    public boolean isStrike() {
        return downCount == BowlingConstants.PIN_COUNT;
    }

    private boolean isGutter() {
        return downCount == 0;
    }

    public boolean isSpare(Optional<Try> firstTry) {
        return firstTry.isPresent() && firstTry.get().isSpare(downCount);
    }

    private boolean isSpare(int otherDownCount) {
        return this.downCount + otherDownCount == BowlingConstants.PIN_COUNT;
    }

    public String getDownMessage() {
        if (isGutter()) {
            return "-";
        }
        return String.valueOf(downCount);
    }
}
