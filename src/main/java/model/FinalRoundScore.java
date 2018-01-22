package model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FinalRoundScore {
    private List<Ball> bowlingBalls;
    private int count;

    public FinalRoundScore() {
        bowlingBalls = IntStream.range(0, 3)
                .mapToObj(i -> new Ball())
                .collect(Collectors.toList());

        count = 0;
    }

    public boolean bowl(int number) throws IllegalArgumentException {
        if (!isValidNumber(number))
            throw new IllegalArgumentException();

        setPinCount(count, number);
        count++;

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
        if (count == 2 && getScoreSum() < 10)
            return true;
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
