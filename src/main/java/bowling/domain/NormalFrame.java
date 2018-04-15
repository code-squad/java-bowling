package bowling.domain;

import java.util.List;

public class NormalFrame implements Frame {
    private Integer firstScore;
    private Integer secondScore;

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

    public boolean isNotValidInput(int pinsKnocked) {
        if (pinsKnocked > ALL || pinsKnocked < NONE) {
            return true;
        }
        return firstBallPlayed() && !isStrike() && pinsKnocked > ALL - firstScore;
    }

    public Integer throwBall(int pinsKnocked) throws IllegalArgumentException {
        if (isNotValidInput(pinsKnocked)) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
        if (!firstBallPlayed()) {
            return firstScore = pinsKnocked;
        }
        if (!secondBallPlayed()) {
            return secondScore = pinsKnocked;
        }
        return null;
    }

    public Integer calculateFrameScore(List<Frame> frames, int frameNumber) {
        Frame nextFrame = frames.get(frameNumber + 1);
        if (!this.firstBallPlayed() || !this.secondBallPlayed()) {
            return null;
        }
        if ((this.isStrike() || this.isSpare()) && !nextFrame.firstBallPlayed()) {
            return null;
        }
        if ((this.isStrike() && !nextFrame.secondBallPlayed())) {
            return null;
        }
        return calculateBaseSum() + nextFrame.calculateBonus(this);
    }

    private Integer calculateBaseSum() {
        if (this.isStrike()) {
            return firstScore;
        }
        return firstScore + secondScore;
    }

    public int calculateBonus(Frame prevFrame) {
        if (prevFrame.isSpare()) {
            return firstScore;
        }
        return calculateBaseSum();
    }

    public Integer getFirstScore() {
        return firstScore;
    }

    public Integer getSecondScore() {
        return secondScore;
    }
}