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

    private boolean thirdBallPlayed() {
        return thirdScore != null;
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

    public Integer calculateFrameScore(List<Frame> frames, int frameNumber) {
        return calculateBaseSum();
    }

    private Integer calculateBaseSum() {
        if (!this.firstBallPlayed() || !secondBallPlayed() || !thirdBallPlayed()) {
            return null;
        }
        return firstScore + secondScore + thirdScore;
    }

    public Integer calculateBonus(Frame prevFrame) {
        if (prevFrame.isSpare()) {
            return firstScore;
        }
        if (prevFrame.isStrike()) {
            return firstScore + secondScore;
        }
        return NONE;
    }

    public Integer getFirstScore() {
        return firstScore;
    }

    public Integer getSecondScore() {
        return firstScore;
    }

    public Integer getThirdScore() {
        return firstScore;
    }
}