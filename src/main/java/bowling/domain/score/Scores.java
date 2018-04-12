package bowling.domain.score;

public class Scores {
    static final int ALL = 10;
    static final int NONE = 0;

    private Score firstScore = new FirstScore();
    private Score secondScore = new SecondScore();
    private int pinsStanding = ALL;

    public boolean updateFirstThrow(int pinsKnocked) throws IllegalArgumentException {
        if (isValidScore(pinsKnocked)) {
            firstScore.updateScore(pinsKnocked);
            pinsStanding -= pinsKnocked;
            return true;
        }
        throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
    }

    public boolean updateSecondThrow(int pinsKnocked) throws IllegalArgumentException {
        if (isValidScore(pinsKnocked)) {
            secondScore.updateScore(pinsKnocked);
            pinsStanding -= pinsKnocked;
            return true;
        }
        throw new IllegalArgumentException("입력된 숫자가 남은 핀의 개수보다 큽니다.");
    }

    public boolean firstThrowPlayed() {
        return firstScore.isPlayed();
    }

    public boolean isStrike() {
        return firstScore.isPlayed()
                && !secondScore.isPlayed()
                && pinsStanding == NONE;
    }

    public boolean secondThrowPlayed() {
        return secondScore.isPlayed();
    }

    public boolean isSpare() {
        return firstScore.isPlayed()
                && secondScore.isPlayed()
                && pinsStanding == NONE;
    }

    public boolean isValidScore(int pinsKnocked) {
        return pinsKnocked > ALL
                || pinsKnocked < NONE
                || pinsKnocked > pinsStanding;
    }

    @Override
    public String toString() {
        return firstScore.toString(isStrike()) + secondScore.toString(isSpare());
    }
}