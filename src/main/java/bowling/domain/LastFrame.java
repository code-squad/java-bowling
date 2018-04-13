package bowling.domain;

public class LastFrame implements NormalFrame {
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

    public Integer throwBall(int pinsKnocked) {
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