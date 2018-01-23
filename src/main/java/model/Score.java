package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Score {

    private List<Ball> bowlingBalls;

    public Score() {
        this.bowlingBalls = new ArrayList<>();
    }

    private void checkValidInput(Ball ball) {
        if (getScoreSum() + ball.getPinCount() > getLimitOfSum())
            throw new IllegalArgumentException();
    }

    private int getLimitOfSum() {
        return 10 * (getScoreSum() / 10 + 1);
    }

    public boolean isStrike() {
        if (bowlingBalls.size() == 0)
            return false;

        return getScoreSum(1) == 10;
    }

    public boolean isSpare() {
        if (isStrike())
            return false;

        if (bowlingBalls.size() < 2)
            return false;

        return getScoreSum(2) == 10;
    }

    public int size() {
        return bowlingBalls.size();
    }

    public void add(Ball ball) {
        checkValidInput(ball);

        bowlingBalls.add(ball);
    }

    public int getScoreSum() {
        return bowlingBalls.stream()
                .mapToInt(Ball::getPinCount)
                .sum();
    }

    public int getScoreSum(int count) {
        if (count > bowlingBalls.size())
            throw new IllegalArgumentException();

        int result = 0;

        for (int i = 0; i < count; i++) {
            result += bowlingBalls.get(i).getPinCount();
        }

        return result;
    }

    @Override
    public String toString() {
        String str = bowlingBalls.stream()
                .map(Ball::toString)
                .collect(Collectors
                        .joining("|"));
        if (isSpare()) {
            return str.substring(0, 2) + "/" + str.substring(3);
        }

        return str;
    }
}
