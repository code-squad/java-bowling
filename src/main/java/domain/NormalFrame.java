package domain;

public class NormalFrame extends Frame {

    private NormalFrame() {
        super(Scores.of());
    }

    public static Frame of() {
        return new NormalFrame();
    }

    @Override
    public boolean isValidScore(int score) {
        return isValidScoreForNormalCase(score);
    }

    @Override
    public boolean isFrameEnd() {
        return isTen() || isTrySecond();
    }

}
