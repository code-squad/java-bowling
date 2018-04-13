package bowling.domain;

public class NormalFrame implements Frame {
    private static final int ALL = 10;
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

        if (pinsKnocked > ALL || pinsKnocked < 0) {
            return true;
        }
        return !isStrike() && pinsKnocked > ALL - firstScore;
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

    public Integer calculateSum() {
        return firstScore + secondScore;
    }
}