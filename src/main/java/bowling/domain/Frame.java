package bowling.domain;

import bowling.domain.state.Ready;
import bowling.domain.state.State;

public abstract class Frame {
    protected State state = new Ready();

    public abstract void rollBowlingBall(Pin pin);
    public abstract int getScore();
    public abstract boolean isFrameEnd();
    public abstract String getFrameView();
    public abstract int calculateAdditionalScore(Score score);
}
