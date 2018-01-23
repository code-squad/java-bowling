package bowling.domain;

import java.util.Objects;
import java.util.Random;

public class Roll {

    private final static int MIN_PIN_COUNT = 0;
    private final static int MAX_PIN_COUNT = 10;

    private int pinCount;

    public Roll() {
        makeRoll(new Random().nextInt(MAX_PIN_COUNT+1));
    }

    public Roll(int pinCount) {
        makeRoll(pinCount);
    }

    private void makeRoll(int pinCount) {
        if (outOfRange(pinCount)) throw new IllegalArgumentException();
        this.pinCount = pinCount;
    }

    private boolean outOfRange(int pinCount) {
        return pinCount < MIN_PIN_COUNT || pinCount > MAX_PIN_COUNT;
    }

    public BowlingScore toBowlingScore () {
        return BowlingScore.of(this);
    }

    public boolean isSpare() {
        return toBowlingScore() == BowlingScore.SPARE;
    }

    public boolean equals(int number) {
        return pinCount == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roll roll = (Roll) o;
        return pinCount == roll.pinCount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(pinCount);
    }

    @Override
    public String toString() {
        return "" + pinCount;
    }
}
