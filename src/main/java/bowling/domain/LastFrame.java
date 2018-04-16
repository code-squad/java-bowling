package bowling.domain;

import java.util.List;

public class LastFrame implements Frame {
    private Ball firstBall;
    private Ball secondBall;
    private Ball bonusBall;

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

    private boolean bonusBallNotPlayed() {
        return bonusBall == null;
    }

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
        }
        if (isStrike()) {
            bonusBall = new BonusBall(ALL, pinsKnocked);
        }
        bonusBall = new BonusBall(secondBall.getPinsLeft(), pinsKnocked);
        return true;
    }

    public Integer calculateFrameScore(List<Frame> frames, int frameNumber) {
        if (firstBallNotPlayed() || secondBallNotPlayed()) {
            return null;
        }
        if (bonusBallNotPlayed()) {
            return calculateTotal();
        }
        return calculateTotal() + (ALL - bonusBall.getPinsLeft());
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
            return firstBall.toString() + "|" + "   ";
        }
        if (bonusBallNotPlayed()) {
            return firstBall.toString() + "|" + secondBall.toString() + "| ";
        }
        return firstBall.toString() + "|" + secondBall.toString() + "|" + bonusBall.toString();
    }
}