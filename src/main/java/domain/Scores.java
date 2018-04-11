package domain;

public class Scores {
    private Score firstScore;
    private Score secondScore;
    private int pinsStanding;

    public Scores() {
        this.firstScore = new FirstScore();
        this.secondScore = new SecondScore();
        this.pinsStanding = 10;
    }

    public void updateFirstThrow(int pinsKnocked) {
        firstScore.updateScore(pinsKnocked);
        pinsStanding -= pinsKnocked;
    }

    public boolean isStrike() {
        return firstScore.isPlayed()
                && !secondScore.isPlayed()
                && pinsStanding == 0;
    }

    public void updateSecondThrow(int pinsKnocked) {
        secondScore.updateScore(pinsKnocked);
        pinsStanding -= pinsKnocked;
    }

    public boolean isSpare() {
        return firstScore.isPlayed()
                && secondScore.isPlayed()
                && pinsStanding == 0;
    }

    @Override
    public String toString() {
        return firstScore.toString(isStrike()) + secondScore.toString(isSpare());
    }
}