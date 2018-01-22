package model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RoundScore {

    private List<Ball> bowlingBalls;

    public RoundScore(int size) {
        bowlingBalls = IntStream.range(0, size)
                .mapToObj(i -> new Ball())
                .collect(Collectors.toList());
    }

    public boolean bowl(int number) throws IllegalArgumentException {
        if (!isValidNumber(number))
            throw new IllegalArgumentException();

        Ball first = this.bowlingBalls.get(0);
        if (!first.isPlayed()) {
            setPinCount(0, number);
            return true;
        }

        if (isStrike())
            return false;

        if (first.getPinCount() + number > 10)
            throw new IllegalArgumentException();

        Ball second = this.bowlingBalls.get(1);
        if (!second.isPlayed()) {
            setPinCount(1, number);
            return true;
        }

        return false;
    }

    public boolean isStrike() {
        Ball first = bowlingBalls.get(0);
        return first.getPinCount() == 10;
    }

    public boolean isSpare() {
        Ball first = bowlingBalls.get(0);
        Ball second = bowlingBalls.get(1);
        if (!second.isPlayed())
            return false;
        return (first.getPinCount() + second.getPinCount()) == 10;
    }

    public int getPinCount(int index) throws IndexOutOfBoundsException {
        return bowlingBalls.get(index).getPinCount();
    }

    public void setPinCount(int index, int number) {
        this.bowlingBalls.get(index).setPinCount(number);
    }

    public int getScoreSum() {
        return bowlingBalls.stream()
                .mapToInt(Ball::getPinCount)
                .sum();
    }

    private boolean isValidNumber(int number) {
        return (number >= 0 && number <= 10);
    }

    public boolean isFinished() {
        Ball first = bowlingBalls.get(0);
        if (isStrike()) return true;
        Ball second = bowlingBalls.get(1);
        if (first.isPlayed() && second.isPlayed()) return true;
        return false;
    }

    @Override
    public String toString() {
        Ball first = bowlingBalls.get(0);
        Ball second = bowlingBalls.get(1);

        if (isStrike()) return first.toString();
        if (isSpare()) return first.toString() + "|/";
        return first.toString() + "|" + second.toString();
    }
}
