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

    public int getBallsSum(int count) {
        if (count > bowlingBalls.size()) throw new IllegalArgumentException();

        int result = 0;

        for (int i = 0; i <count; i++){
            result += bowlingBalls.get(i).getPinCount();
        }

        return result;
    }

    public int getBallsSum() {

        return getBallsSum(bowlingBalls.size());
    }


    public boolean isStrike() {
        if(bowlingBalls.size() == 0)
            return false;

        Ball first = bowlingBalls.get(0);
        return first.getPinCount() == 10;
    }

    public boolean isSpare() {
        if (isStrike())
            return false;

        if (bowlingBalls.size() < 2)
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

        String str = bowlingBalls.stream().map(Ball::toString).collect(Collectors.joining("|"));
        if(this.isSpare()) {
            return str.substring(0, 2) + "/" + str.substring(3);
        }

        return str;
    }
}
