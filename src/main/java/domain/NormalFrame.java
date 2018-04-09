package domain;

public class NormalFrame extends Frame {

    private NormalFrame() {
        scores = Scores.of();
    }

    public static Frame of() {
        return new NormalFrame();
    }

    @Override
    public boolean isFrameEnd() {
        return scores.isTen() || scores.isTrySecond();
    }



}
