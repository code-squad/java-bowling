package domain;

public class NormalFrame extends Frame {

    private NormalFrame() {
        super();
    }

    public static Frame of() {
        return new NormalFrame();
    }

    public ScoreCalculator initScoreCalculator() {
        return ScoreCalculator.of();
    }

    @Override
    public boolean isFrameEnd() {
        return isFirstStrike() || isTrySecond();
    }

}
