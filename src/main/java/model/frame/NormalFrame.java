package model.frame;

import model.Shoot;
import model.Pin;

public class NormalFrame implements Frame {
    private Pin pin;
    private Frame nextFrame;
    private int round;

    public NormalFrame(int round) {
        this.round = round;
        this.nextFrame = Frame.of(round + 1);
        this.pin = new Pin();
    }

    @Override
    public void bowl(int number) {
        if (isFinished()) {
            this.nextFrame.bowl(number);
            return;
        }

        this.pin.add(new Shoot(number));
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
        int sum = this.pin.getScoreSum();
        try {
            if (this.pin.isSpare())
                sum += getNextFrame().getNextBallSum(1);
            if (this.pin.isStrike())
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
            return this.pin.getScoreSum(1) + this.nextFrame.getNextBallSum(count - 1);

        return this.pin.getScoreSum(2) + this.nextFrame.getNextBallSum(count - 2);
    }

    @Override
    public boolean isStrike() {
        return this.pin.isStrike();
    }

    @Override
    public boolean isFinished() {
        if (this.pin.size() == 0)
            return false;

        if (this.pin.isStrike() && this.pin.size() == 1)
            return true;

        return this.pin.size() == 2;
    }

    @Override
    public String toString() {
        return this.pin.toString();
    }
}
