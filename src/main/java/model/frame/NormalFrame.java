package model.frame;

import model.Ball;
import model.Score;

public class NormalFrame implements Frame {
    private int round;
    protected Score score;
    private Frame nextFrame;

    public NormalFrame(int round) {
        this.round = round;
        this.nextFrame = Frame.of(round + 1);
        score = new Score();
    }

    public void bowl(int number) {
        if (isFinished()) {
            nextFrame.bowl(number);
        }

        score.add(new Ball(number));
    }

    public Frame getNextFrame() {
        return nextFrame;
    }

    @Override
    public String toString() {
        return score.toString();
    }

    @Override
    public boolean isFinished() {
        if (this.score.size() == 0)
            return false;

        if (this.score.isStrike() && this.score.size() == 1)
            return true;

        if (this.score.size() == 2)
            return true;

        return false;
    }
}
