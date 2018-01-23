package model.frame;

import model.Ball;
import model.Score;

public class FinalFrame implements Frame {
    private Score score;
    private int availableCount;
    private int round;

    public FinalFrame() {
        this.round = 10;
        this.score = new Score();
        this.availableCount = 2;
    }

    @Override
    public void bowl(int number) {
        if (this.availableCount == 0)
            throw new IllegalStateException();

        int size = this.score.size();

        this.score.add(new Ball(number));

        if (size == 0 && number != 10) {
            this.availableCount--;
        }

        if (size == 1 && !score.isSpare()) {
            this.availableCount--;
        }

        if (size == 2) {
            this.availableCount--;
        }
    }

    @Override
    public int getRound() {
        return this.round;
    }

    @Override
    public Frame getNextFrame() {
        return null;
    }

    @Override
    public int getScoreSum() {
        return this.score.getScoreSum();
    }

    @Override
    public int getNextBallSum(int count) {
        return this.score.getScoreSum(count);
    }

    @Override
    public boolean isStrike() {
        return this.score.isStrike();
    }

    @Override
    public boolean isFinished() {
        return this.availableCount == 0;
    }

    @Override
    public String toString() {
        return this.score.toString();
    }

}
