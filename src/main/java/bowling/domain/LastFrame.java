package bowling.domain;

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

    public boolean isNotValidInput(int pinsKnocked) {
        if (pinsKnocked > ALL || pinsKnocked < 0) {
            return true;
        }
        return !secondBallPlayed() && !isStrike() && pinsKnocked > ALL - firstScore;
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

    public Integer calculateSum() {
        return firstScore + secondScore;
    }
}