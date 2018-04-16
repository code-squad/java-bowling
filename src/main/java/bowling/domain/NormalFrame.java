package bowling.domain;

import java.util.List;

public class NormalFrame implements Frame, Printable {
    private Ball firstBall;
    private Ball secondBall;

    @Override
    public boolean isStrike() {
        return !firstBallNotPlayed()
                && firstBall.getPinsLeft() == NONE;
    }

    private int calculateTotal() {
        return ALL - secondBall.getPinsLeft();
    }

    @Override
    public boolean isSpare() {
        return !secondBallNotPlayed()
                && calculateTotal() == ALL;
    }

    @Override
    public boolean firstBallNotPlayed() {
        return firstBall == null;
    }

    @Override
    public boolean secondBallNotPlayed() {
        return secondBall == null;
    }

    @Override
    public boolean isComplete() {
        return isStrike() || isSpare() || !secondBallNotPlayed();
    }

    @Override
    public boolean throwBall(int pinsKnocked) {
        if (firstBallNotPlayed()) {
            firstBall = new FirstBall(pinsKnocked);
            return true;
        }
        secondBall = new SecondBall(firstBall.getPinsLeft(), pinsKnocked);
        return true;
    }

    @Override
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

    @Override
    public Integer calculateBonus(Frame prevFrame) {
        if (prevFrame.isSpare()) {
            return ALL - firstBall.getPinsLeft();
        }
        return calculateTotal();
    }

    @Override
    public String toString() {
        if (firstBallNotPlayed()) {
            return " ";
        }
        if (secondBallNotPlayed()) {
            return firstBall.toString()
                    + "  ";
        }
        return firstBall.toString()
                + "|"
                + secondBall.toString();
    }
}