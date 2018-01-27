package bowling.domain;


import bowling.domain.state.Spare;
import bowling.domain.state.Strike;
import bowling.exception.CannotCalculateException;

public class FinalFrame extends Frame {

    @Override
    public void rollBowlingBall(int pin) {
        if(isFrameEnd())
            return;

        state = state.bowlBall(new Pin(pin));
    }

    @Override
    public boolean isFrameEnd() {
        if(state instanceof Strike || state instanceof Spare)
            return false;

        return state.isFrameEnd();
    }

    @Override
    public String getFrameView() {
        return state.toFrameView();
    }

    @Override
    public int getScore() {
        Score score = state.getScore();

        if(score.calculable())
            return score.getScore();

        throw new CannotCalculateException();
    }

    @Override
    public int calculateAdditionalScore(Score score) {
        Score addedScore = state.addScore(score);

        if(addedScore.calculable())
            return addedScore.getScore();

        throw new CannotCalculateException();
    }
}
