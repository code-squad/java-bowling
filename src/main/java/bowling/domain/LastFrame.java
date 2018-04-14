package bowling.domain;

import java.util.List;

public class LastFrame implements Frame {
    private Integer firstScore;
    private Integer secondScore;
    private Integer thirdScore;

    public boolean firstBallPlayed() {
        return firstScore != null;
    }

    public boolean secondBallPlayed() {
        return secondScore != null;
    }

    public boolean isStrike() {
        return firstScore.equals(ALL);
    }

    public boolean isSpare() {
        return secondScore.equals(ALL - firstScore);
    }

    private boolean secondIsStrike() {
        return secondScore.equals(ALL);
    }

    public boolean isNotValidInput(int pinsKnocked) {
        if (pinsKnocked > ALL || pinsKnocked < NONE) {
            return true;
        }
        return firstBallPlayed() && !isStrike()
                && !secondBallPlayed()
                && pinsKnocked > ALL - firstScore; //case where second ball knocks more pins than there are
    }

    public Integer throwBall(int pinsKnocked) throws IllegalArgumentException {
        if (isNotValidInput(pinsKnocked)) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다");
        }
        if (!firstBallPlayed()) {
            return firstScore = pinsKnocked;
        }
        if (!secondBallPlayed()) {
            return secondScore = pinsKnocked;
        }
        if (secondBallPlayed()) {
            return thirdScore = pinsKnocked;
        }
        return null;
    }

    public int calculateFrameScore(List<Frame> frames, int frameNumber) {
        return calculateSum();
    }

    public Integer calculateSum() {
        if (isStrike() || isSpare()) {
            return firstScore + secondScore + thirdScore;
        }
        return firstScore + secondScore;
    }

    public int calculateBonus(Frame prevFrame) {
        if (prevFrame.isSpare()) {
            return firstScore;
        }
        if (prevFrame.isStrike()) {
            return firstScore + secondScore;
        }
        return NONE;
    }
}