package model.frame;

import model.Ball;
import model.Score;

public class NormalFrame implements Frame {
    private Score score;
    private Frame nextFrame;
    private int round;

    public NormalFrame(int round) {
        this.round = round;
        this.nextFrame = Frame.of(round + 1);
        this.score = new Score();
    }

    @Override
    public void bowl(int number) {
        if (isFinished()) {
            this.nextFrame.bowl(number);
            return;
        }

        this.score.add(new Ball(number));
    }

    @Override
    public int getRound() {
        return this.round;
    }

    public Frame getNextFrame() {
        return this.nextFrame;
    }

    @Override
    public int getScoreSum() {
        int sum = this.score.getScoreSum();
        try {
            if (this.score.isSpare())
                sum += getNextFrame().getNextBallSum(1);
            if (this.score.isStrike())
                sum += getNextFrame().getNextBallSum(2);
        } catch (IllegalArgumentException e) {
            return -1;
        }
        return sum;
    }

    @Override
    public int getNextBallSum(int count) {
        if (count == 0)
            return 0;

        if (count == 1 || isStrike())
            return this.score.getScoreSum(1) + this.nextFrame.getNextBallSum(count - 1);

        return this.score.getScoreSum(2) + this.nextFrame.getNextBallSum(count - 2);
    }

    @Override
    public boolean isStrike() {
        return this.score.isStrike();
    }

    @Override
    public boolean isFinished() {
        if (this.score.size() == 0)
            return false;

        if (this.score.isStrike() && this.score.size() == 1)
            return true;

        return this.score.size() == 2;
    }

    @Override
    public String toString() {
        return this.score.toString();
    }
}
