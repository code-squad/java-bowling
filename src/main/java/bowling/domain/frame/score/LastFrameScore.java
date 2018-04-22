package bowling.domain.frame.score;

public class LastFrameScore {
    private final int score;
    private final boolean readyForCalc;

    private LastFrameScore(int score, boolean readyForCalc) {
        this.score = score;
        this.readyForCalc = readyForCalc;
    }

    public static LastFrameScore ofReady(int score) {
        return new LastFrameScore(score, true);
    }

    public static LastFrameScore ofNotReady(int score) {
        return new LastFrameScore(score, false);
    }

    @Override
    public String toString() {
        if (readyForCalc) {
            return String.valueOf(score);
        }
        return "";
    }
}