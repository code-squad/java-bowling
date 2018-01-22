package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Score {

    private List<Ball> bowlingBalls;

    public Score() {
        this.bowlingBalls = new ArrayList<>();
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

    public int size() {
        return bowlingBalls.size();
    }

    public void add(Ball ball) {
        bowlingBalls.add(ball);
    }

    public int getScoreSum() {
        return bowlingBalls.stream()
                .mapToInt(Ball::getPinCount)
                .sum();
    }

    @Override
    public String toString() {
        return bowlingBalls.stream()
                .map(Ball::toString)
                .filter(i -> !i.equals(""))
                .collect(Collectors.joining("|"));
    }
}
