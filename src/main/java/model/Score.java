package model;

import model.Ball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Score {

    private List<Ball> bowlingBalls;

    public Score(List<Ball> bowlingBalls) {
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

    public int size() {
        return bowlingBalls.size();
    }

    public int getScoreSum() {
        return bowlingBalls.stream()
                .mapToInt(Ball::getPinCount)
                .sum();
    }

    @Override
    public String toString() {
//        if (bowlingBalls.size() < 3){
//            Ball first = bowlingBalls.get(0);
//            if (isStrike()) return first.toString();
//            Ball second = bowlingBalls.get(1);
//            if (isSpare()) return first.toString() + "|/";
//            return first.toString() + "|" + second.toString();
//        }
//        String result = "";
//        Ball first = bowlingBalls.get(0);
//        if (isStrike()) result += first.toString();
//        Ball second = bowlingBalls.get(1);
//        if (isSpare()) result += "|/";
//        Ball third = bowlingBalls.get(2);
//        result += third;

        return bowlingBalls.stream().map(Ball::toString).filter(i -> !i.equals("")).collect(Collectors.joining("|"));
    }
}
