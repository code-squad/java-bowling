package model.frame;

import model.Ball;
import model.Score;

public class FinalFrame implements Frame {
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

        score.add(new Ball(number));

        if (size == 0 && number != 10) {
            availableCount--;
        }

        if (size == 1 && !score.isSpare()) {
            availableCount--;
        }

        if (size == 2) {
            availableCount--;
        }
    }

    @Override
    public boolean isFinished() {
        return availableCount == 0;
    }

    @Override
    public int getScore() {
        return score.getScoreSum();
    }

    @Override
    public int getNextBallSum(int count) {
        return 0;
    }

    @Override
    public Frame getNextFrame() {
        return null;
    }

    @Override
    public String toString() {
        return score.toString();
    }

    @Override
    public boolean isStrike() {
        return score.isStrike();
    }

}
