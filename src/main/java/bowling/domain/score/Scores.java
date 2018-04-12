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

    public boolean firstThrowIsNotPlayed() {
        return firstScore.isNotPlayed();
    }

    public boolean isStrike() {
        return firstScore.isNotPlayed()
                && !secondScore.isNotPlayed()
                && pinsStanding == NONE;
    }

    public boolean secondThrowIsNotPlayed() {
        return secondScore.isNotPlayed();
    }

    public boolean isSpare() {
        return firstScore.isNotPlayed()
                && secondScore.isNotPlayed()
                && pinsStanding == NONE;
    }

    public boolean isValidScore(int pinsKnocked) {
        if (pinsKnocked > ALL || pinsKnocked < NONE) {
            return false;
        }
        if (pinsKnocked > pinsStanding) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstScore.toString(isStrike()) + secondScore.toString(isSpare());
    }
}