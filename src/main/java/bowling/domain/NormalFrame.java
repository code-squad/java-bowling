package bowling.domain;

public class NormalFrame extends Frame {
    private Frame nextFrame;

    public NormalFrame(Frame nextFrame) {
        if(nextFrame == null)
            throw new IllegalArgumentException("Next frame can't be a null");

        this.nextFrame = nextFrame;
    }

    @Override
    public void rollBowlingBall(int pin) {
        if(isFrameEnd())
            nextFrame.rollBowlingBall(pin);

        state = state.bowlBall(new Pin(pin));
    }

    @Override
    public int getScore() {
        Score score = state.getScore();

        if(score.calculable())
            return score.getScore();

        return nextFrame.calculateAdditionalScore(score);
    }

    @Override
    public boolean isFrameEnd() {
        return state.isFrameEnd();
    }

    @Override
    public String getFrameView() {
        return state.toFrameView();
    }

    @Override
    public int calculateAdditionalScore(Score score) {
        Score addedScore = state.addScore(score);

        if(addedScore.calculable())
            return addedScore.getScore();

        return nextFrame.calculateAdditionalScore(addedScore);
    }
}
