package bowling.domain.number;

import bowling.util.ScoreAssistance;

import java.util.Objects;
import java.util.Random;

public class Roll {

    private final static int MIN_PIN_COUNT = 0;

    private Integer downCount;
    private MaxCount maxCount;

    public Roll() {
        makeRoll(getRandomCount());
    }

    public Roll(Integer downCount) {
        makeRoll(downCount);
    }

    public Roll(MaxCount maxCount) {
        this.maxCount = maxCount;
        makeRoll(getRandomCount());
    }

    public Roll(Integer downCount, MaxCount maxCount) {
        this.maxCount = maxCount;
        makeRoll(downCount);
    }

    private Integer getRandomCount() {
        return new Random().nextInt(maxCount.toInteger()+1);
    }

    private void makeRoll(Integer downCount) {
        if (maxCount == null) {
            this.maxCount = new MaxCount(ScoreAssistance.MAX_PIN_COUNT);
        }
        this.downCount = downCount;
        if (outOfRange()) throw new IllegalArgumentException();
    }

    private boolean outOfRange() {
        return downCount < MIN_PIN_COUNT || downCount > maxCount.toInteger() || downCount > maxCount.toInteger();
    }

    public BowlingScore toBowlingScore () {
        return BowlingScore.of(this);
    }

    public boolean isSpare() {
        return toBowlingScore() == BowlingScore.SPARE;
    }

    public boolean equals(int number) {
        return downCount.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roll roll = (Roll) o;
        return downCount == roll.downCount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(downCount);
    }

    @Override
    public String toString() {
        return String.valueOf(downCount);
    }
}