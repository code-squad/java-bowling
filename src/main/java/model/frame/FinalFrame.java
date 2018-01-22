package model.frame;

import model.Ball;
import model.Score;

import java.util.ArrayList;
import java.util.List;

public class FinalFrame implements Frame {

    private static final int ROUND = 10;
    private List<Ball> bowls;
    private Score score;
    private int availableCount;

    public FinalFrame() {
        this.bowls = new ArrayList<>();
        availableCount = 2;
    }

    @Override
    public void bowl(int number) {
        if (availableCount == 0)
            throw new IllegalStateException();

        int size = bowls.size();

        if (size == 0) {
            // Strike
            if (number == 10) {
                bowls.add(new Ball(10));
                return;
            }
            bowls.add(new Ball(number));
            availableCount--;
            return;
        }

        if (size == 1) {
            bowls.add(new Ball(number));

            // NotSpare
            if (bowls.get(0).getPinCount() + number != 10) {
                availableCount--;
            }
        }

        if (size == 2) {
            bowls.add(new Ball(number));
        }

        if (availableCount == 0)
            this.score = new Score(bowls);
    }

    @Override
    public Frame getNextFrame() {
        return null;
    }

    @Override
    public String toString() {
        if (score == null)
            return " ";
        return score.toString();
    }
}
