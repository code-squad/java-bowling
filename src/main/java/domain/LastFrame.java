package domain;

public class LastFrame extends Frame {

    private LastFrame() {
        scores = Scores.of();
    }

    public static Frame of() {
        return new LastFrame();
    }

    @Override
    public boolean isFrameEnd() {
        if (scores.isTryThird()) return true;
        if (scores.isTrySecond() && scores.isTotalScoreUnderTen()) return true;
        return false;
    }

    @Override
    public String toString() {
        if (isSpare()) return scores.firstString() + "|"+Figure.SPARE;
        if (isStrike()) return Figure.STRIKE.toString();
        if (isDouble()) return Figure.STRIKE.toString();
        if (isTurkey()) return Figure.STRIKE.toString();
        return scores.toString();
    }

    private boolean isDouble() {
        return scores.isTrySecond() && scores.isTwenty();
    }

    private boolean isTurkey() {
        return scores.isTryThird() && scores.isThirty();
    }

}
