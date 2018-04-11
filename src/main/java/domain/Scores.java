package domain;

public class Scores {
    static final int ALL = 10;
    static final int NONE = 0;
    private Score firstScore;
    private Score secondScore;
    private int pinsStanding;

    public Scores() {
        this.firstScore = new FirstScore();
        this.secondScore = new SecondScore();
        this.pinsStanding = ALL;
    }

    public void updateFirstThrow(int pinsKnocked) {
        firstScore.updateScore(pinsKnocked);
        pinsStanding -= pinsKnocked;
    }

    public boolean isStrike() {
        return firstScore.isPlayed()
                && !secondScore.isPlayed()
                && pinsStanding == NONE;
    }

    public void updateSecondThrow(int pinsKnocked) {
        secondScore.updateScore(pinsKnocked);
        pinsStanding -= pinsKnocked;
    }

    public boolean isSpare() {
        return firstScore.isPlayed()
                && secondScore.isPlayed()
                && pinsStanding == NONE;
    }

    @Override
    public String toString() {
        return firstScore.toString(isStrike()) + secondScore.toString(isSpare());
    }
}