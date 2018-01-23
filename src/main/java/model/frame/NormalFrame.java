package model.frame;

import model.Ball;
import model.Score;

import java.util.List;

public class NormalFrame implements Frame {
    private Score score;
    private Frame nextFrame;

    public NormalFrame(int round) {
        this.nextFrame = Frame.of(round + 1);
        score = new Score();
    }

    public void bowl(int number) {
        if (isFinished()) {
            nextFrame.bowl(number);
            return;
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

        return this.score.size() == 2;
    }

    @Override
    public int getScore() {
        int sum = score.getScoreSum();
        if (score.isSpare())
            sum += getNextFrame().getNextBallSum(1);
        if (score.isStrike())
            sum += getNextFrame().getNextBallSum(2);
        return sum;
    }

    @Override
    public int getNextBallSum(int count) {
        if (count == 0) return 0;

        if (count == 1) return score.getBallsSum(1);

        if (isStrike()) return score.getBallsSum(1) + nextFrame.getNextBallSum(count -1);
        return score.getBallsSum(2) + nextFrame.getNextBallSum(count - 2);

    }

    @Override
    public boolean isStrike() {
        return score.isStrike();
    }

}
