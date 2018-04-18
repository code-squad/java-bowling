package bowling.domain;

public class LastFrame {
    private State state;
    private Score score;

    public void bowl(int pins) {
        state = state.bowl(pins);
        score = state.createScore();
    }

    public int getScore(Frame nextFrame) {
        if (score.canBeCalculated()) {
            return score.getScore() + nextframe.calculateAdditionalScore();
        }
        return score.getScore() + nextFrame.calculateAdditionalScore();
    }

    public int calculateAdditionalScore() {
        return score.getScore();
    }
}