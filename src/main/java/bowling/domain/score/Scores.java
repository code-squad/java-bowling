package bowling.domain.score;

public class Scores {
    static final int ALL = 10;
    static final int NONE = 0;

    private FirstScore firstScore = new FirstScore();
    private SecondScore secondScore = new SecondScore();

    public boolean updateFirstThrow(int pinsKnocked) throws IllegalArgumentException {
        if (isValidScore(pinsKnocked)) {
            firstScore.updateScore(pinsKnocked);
            return true;
        }
        throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
    }

    public boolean updateSecondThrow(int pinsKnocked) throws IllegalArgumentException {
        if (isValidScore(pinsKnocked) && !isMoreThanPinsStanding(pinsKnocked)) {
            secondScore.updateScore(pinsKnocked);
            return true;
        }
        throw new IllegalArgumentException("입력된 숫자가 남은 핀의 개수보다 큽니다.");
    }

    public boolean firstThrowIsPlayed() {
        return firstScore.isPlayed();
    }

    public boolean isStrike() {
        return firstScore.isStrike();
    }

    public boolean secondThrowIsPlayed() {
        return secondScore.isPlayed();
    }

    public boolean isSpare() {
        return secondScore.isSpare(firstScore);
    }

    boolean isValidScore(int pinsKnocked) {
        return !(pinsKnocked > ALL || pinsKnocked < NONE);
    }

    boolean isMoreThanPinsStanding(int pinsKnocked) {
        return firstScore.isMoreThanPinsStanding(pinsKnocked);
    }

    @Override
    public String toString() {
        return firstScore.toString() + secondScore.toString(firstScore);
    }
}