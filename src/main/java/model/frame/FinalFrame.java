package model.frame;

import model.Ball;
import model.Score;

public class FinalFrame implements Frame {

    private static final int ROUND = 10;
    private Score score;
    private int availableCount;

    public FinalFrame() {
        score = new Score();
        availableCount = 2;
    }

    @Override
    public void bowl(int number) {
        if (availableCount == 0)
            throw new IllegalStateException();

        int size = score.size();

        if (size == 0) {
            // Strike
            if (number == 10) {
                score.add(new Ball(10));
                return;
            }
            score.add(new Ball(number));
            availableCount--;
            return;
        }

        if (size == 1) {
            score.add(new Ball(number));

            // NotSpare
            if (!score.isSpare()) {
                availableCount--;
            }
        }

        if (size == 2) {
            score.add(new Ball(number));
            availableCount--;
        }
    }

    @Override
    public boolean isFinished() {
        if ((score.isStrike() || score.isSpare()) && score.size() == 3)
            return true;
        if (!(score.isStrike() || score.isSpare()) && score.size() == 2)
            return true;

        return false;
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
