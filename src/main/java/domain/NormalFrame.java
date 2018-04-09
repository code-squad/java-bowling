package domain;

public class NormalFrame {
    private static final int MAX = 10;
    private final int score;
    private final boolean strike;
    private final boolean spare;

    private NormalFrame(int score, boolean strike, boolean spare) {
        this.score = score;
        this.strike = strike;
        this.spare = spare;
    }

    public NormalFrame ofNormalFrame(int firstThrow, int secondThrow) {
        if (isStrike(firstThrow)) {
            return new NormalFrame(10, true, false);
        }
        if (isSpare(firstThrow, secondThrow)) {
            return new NormalFrame(10, false, true);
        }
        return new NormalFrame(firstThrow + secondThrow, false, false);
    }

    public static boolean isStrike(int firstThrow) {
        return firstThrow == MAX;
    }

    public static boolean isSpare(int firstThrow, int secondThrow) {
        return firstThrow + secondThrow == MAX;
    }

    @Override
    public String toString() {
        if(strike){
            return ScoreMarker.markStrike();
        }
        if(spare){
            return ScoreMarker.markSpare();
        }
        return ScoreMarker.markNumber();
    }
}
