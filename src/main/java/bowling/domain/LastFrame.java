package bowling.domain;

import java.util.List;

public class LastFrame implements Frame {
    private Ball firstBall;
    private Ball secondBall;
    private Ball bonusBall;

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
        if (!bonusBallNotPlayed()) {
            return true;
        }
        return !isStrike()
                && !isSpare()
                && !secondBallNotPlayed();
    }

    private boolean bonusBallNotPlayed() {
        return bonusBall == null;
    }

    @Override
    public boolean throwBall(int pinsKnocked) {
        if (firstBallNotPlayed()) {
            firstBall = new FirstBall(pinsKnocked);
            return true;
        }
        if (secondBallNotPlayed() && isStrike()) {
            secondBall = new BonusBall(ALL, pinsKnocked);
            return true;
        }
        if (secondBallNotPlayed() && !isStrike()) {
            secondBall = new SecondBall(firstBall.getPinsLeft(), pinsKnocked);
            return true;
        }
        if (isStrike()) {
            bonusBall = new BonusBall(ALL, pinsKnocked);
            return true;
        }
        bonusBall = new BonusBall(secondBall.getPinsLeft(), pinsKnocked);
        return true;
    }

    @Override
    public Integer calculateFrameScore(List<Frame> frames, int frameNumber) {
        if (firstBallNotPlayed() || secondBallNotPlayed()) {
            return null;
        }
        if (bonusBallNotPlayed()) {
            return calculateTotal();
        }
        return calculateTotal() + (ALL - bonusBall.getPinsLeft());
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
            return firstBall.toString();
        }
        if (bonusBallNotPlayed()) {
            return firstBall.toString()
                    + "|"
                    + secondBall.toString()
                    + "|";
        }
        return firstBall.toString()
                + "|"
                + secondBall.toString()
                + "|"
                + bonusBall.toString();
    }
}