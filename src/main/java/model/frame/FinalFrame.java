package model.frame;

import model.Shoot;
import model.Pin;

public class FinalFrame implements Frame {
    private Pin pin;
    private int availableCount;
    private int round;

    public FinalFrame() {
        this.round = 10;
        this.pin = new Pin();
        this.availableCount = 2;
    }

    @Override
    public void bowl(int number) {
        if (this.availableCount == 0)
            throw new IllegalStateException();

        int size = this.pin.size();

        this.pin.add(new Shoot(number));

        if (size == 0 && number != 10) {
            this.availableCount--;
        }

        if (size == 1 && !pin.isSpare()) {
            this.availableCount--;
        }

        if (size == 2) {
            this.availableCount--;
        }
    }

    private int getLimitOfSum() {
        return Pin.MAX_COUNT * (getScoreSum() / Pin.MAX_COUNT + 1);
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
        return this.pin.getScoreSum();
    }

    @Override
    public int getNextBallSum(int count) {
        return this.pin.getScoreSum(count);
    }

    @Override
    public boolean isStrike() {
        return this.pin.isStrike();
    }

    @Override
    public boolean isFinished() {
        return this.availableCount == 0;
    }

    @Override
    public String toString() {
        return this.pin.toString();
    }

}
