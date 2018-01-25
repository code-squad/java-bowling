package bowling.domain.Score;

import bowling.domain.number.BowlingScore;
import bowling.domain.number.MaxCount;
import bowling.domain.number.Pins;
import bowling.util.ScoreAssistance;

import java.util.Objects;
import java.util.Random;

public class Roll {

    private final static int MIN_PIN_COUNT = 0;

    private Pins downCount;
    private MaxCount maxCount;

    public Roll() {
        maxCount = new MaxCount(ScoreAssistance.MAX_PIN_COUNT);
        makeRoll(getRandomPins());
    }

    public Roll(Pins pinCount) {
        maxCount = new MaxCount(ScoreAssistance.MAX_PIN_COUNT);
        makeRoll(pinCount);
    }

    public Roll(MaxCount maxCount) {
        this.maxCount = maxCount;
        if (maxCount == null) {
            this.maxCount = new MaxCount(ScoreAssistance.MAX_PIN_COUNT);
        }
        makeRoll(getRandomPins());
    }

    public Roll(Pins pinCount, MaxCount maxCount) {
        if (pinCount.greaterThan(maxCount.toInteger())) throw new IllegalArgumentException();
        this.maxCount = maxCount;
        makeRoll(pinCount);
    }

    private Pins getRandomPins() {
        return new Pins(new Random().nextInt(maxCount.toInteger()+1));
    }

    private void makeRoll(Pins downCount) {
        if (outOfRange(downCount)) throw new IllegalArgumentException();
        this.downCount = downCount;
    }

    private boolean outOfRange(Pins pinCount) {
        return pinCount.lessThan(MIN_PIN_COUNT) || pinCount.greaterThan(maxCount.toInteger());
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
        return "" + downCount;
    }
}