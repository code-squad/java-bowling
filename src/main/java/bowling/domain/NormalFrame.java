package bowling.domain;

import java.util.List;

public class NormalFrame implements Frame {
    private Ball firstBall;
    private Ball secondBall;

    public boolean isStrike() {
        return firstBall.getPinsLeft() == NONE;
    }

    private int calculateTotal() {
        return ALL - secondBall.getPinsLeft();
    }

    public boolean isSpare() {
        return calculateTotal() == ALL;
    }

    public boolean firstBallNotPlayed() {
        return firstBall == null;
    }

    private boolean secondBallNotPlayed() {
        return secondBall == null;
    }

    public boolean throwBall(int pinsKnocked) throws IllegalArgumentException {
        if (firstBallNotPlayed()) {
            firstBall = new FirstBall(pinsKnocked);
            return true;
        }
        secondBall = new SecondBall(firstBall.getPinsLeft(), pinsKnocked);
        return true;
    }

    public Integer calculateFrameScore(List<Frame> frames, int frameNumber) {
        Frame nextFrame = frames.get(frameNumber + 1);
        if (firstBallNotPlayed() || secondBallNotPlayed()) {
            return null;
        }
        if (!isStrike() || !isSpare()) {
            return calculateTotal();
        }
        if (isStrike() && nextFrame.firstBallNotPlayed()) {
            return null;
        }
        if (isSpare() && nextFrame.firstBallNotPlayed()) {
            return null;
        }
        return calculateTotal() + nextFrame.calculateBonus(this);
    }

    public Integer calculateBonus(Frame prevFrame) {
        if (prevFrame.isSpare()) {
            return ALL - firstBall.getPinsLeft();
        }
        return calculateTotal();
    }

    @Override
    public String toString() {
        if (firstBallNotPlayed()) {
            return "     ";
        }
        if (secondBallNotPlayed()) {
            return " " + firstBall.toString() + "|" + "  ";
        }
        return firstBall.toString() + "|" + secondBall.toString() + "| ";
    }
}