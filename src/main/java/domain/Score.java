package domain;

public class Score {
    private static final int MAX = 10;
    private Integer firstThrow;
    private Integer secondThrow;

    public boolean isStrike() {
        return firstThrow == MAX;
    }

    public boolean isSpare() {
        return firstThrow + secondThrow == MAX;
    }

    public boolean noScoreYet() {
        return firstThrow == null;
    }

    public boolean onlyOneThrown() {
        return firstThrow != null && secondThrow == null;
    }

    public boolean update(int pinsKnocked) {
        if (firstThrow == null) {
            firstThrow = pinsKnocked;
            return true;
        }
        if (firstThrow != null) {
            secondThrow = pinsKnocked;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (noScoreYet()) {
            return "   ";
        }
        if (onlyOneThrown() && isStrike()) {
            return "X  ";
        }
        if (onlyOneThrown()) {
            return String.valueOf(firstThrow);
        }
        if (isSpare()) {
            return firstThrow + "|/";
        }
        return firstThrow + "|" + secondThrow;
    }
}