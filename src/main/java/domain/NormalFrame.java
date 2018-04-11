package domain;

public class NormalFrame extends Frame {
    private Score firstScore;
    private Score secondScore;

    public NormalFrame() {
        this.firstScore = new FirstScore();
        this.secondScore = new SecondScore();
    }

    public void updateFirstThrow(int pinsKnocked) {
        firstScore.updateScore(pinsKnocked);
        firstScore.updatePinsStanding(pinsKnocked);
    }

    public boolean isStrike() {
        return firstScore.isPlayed()
                && !secondScore.isPlayed()
                && firstScore.isNoPinStanding();
    }

    public void updateSecondThrow(int pinsKnocked) {
        secondScore.updateScore(pinsKnocked);
        secondScore.updatePinsStanding(pinsKnocked);
    }

    public boolean isSpare() {
        return firstScore.isPlayed()
                && secondScore.isPlayed()
                && secondScore.isNoPinStanding();
    }

    @Override
    public String toString() {
        return firstScore.toString() + secondScore.toString();
    }
}