package domain;

public class NormalFrame extends Frame {

    private NormalFrame() {
        scores = Scores.of();
    }

    public static Frame of() {
        return new NormalFrame();
    }

    @Override
    public boolean isValidScore(int score) {
        return scores.isValidScoreForNormalCase(score);
    }

    @Override
    public boolean isFrameEnd() {
        return scores.isTen() || scores.isTrySecond();
    }



}
