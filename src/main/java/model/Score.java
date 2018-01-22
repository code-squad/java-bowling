package model;

import model.Ball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Score {

    private List<Ball> bowlingBalls;
    private Ball bonusBall;

    public Score(List<Ball> bowlingBalls) {
//        if (isValidInput(bowlingBalls))
//            throw new IllegalArgumentException();

        int size = bowlingBalls.size();

        if (size < 3) {
            this.bowlingBalls = bowlingBalls;
            return;
        }

        this.bonusBall = bowlingBalls.remove(size - 1);
        this.bowlingBalls = bowlingBalls;
    }

    // To-Do-Later
    private boolean isValidInput(List<Ball> bowlingBalls) {
        if (getScoreSum() > 10)
            return false;
        return true;
    }

    public boolean isStrike() {
        Ball first = bowlingBalls.get(0);
        return first.getPinCount() == 10;
    }

    public boolean isSpare() {
        if (isStrike())
            return false;

        Ball first = bowlingBalls.get(0);
        Ball second = bowlingBalls.get(1);

        return (first.getPinCount() + second.getPinCount()) == 10;
    }

    public int getPinCount(int index) throws IndexOutOfBoundsException {
        return bowlingBalls.get(index).getPinCount();
    }

    public int getScoreSum() {
        return bowlingBalls.stream()
                .mapToInt(Ball::getPinCount)
                .sum();
    }

    @Override
    public String toString() {
        Ball first = bowlingBalls.get(0);
        if (isStrike()) return first.toString();
        Ball second = bowlingBalls.get(1);
        if (isSpare()) return first.toString() + "|/";
        return first.toString() + "|" + second.toString();
    }
}
