package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public abstract class State {
    public abstract State bowlBall(Pin fallenPin);
    public abstract boolean isFrameEnd();
    public abstract String toFrameView();
    public abstract Score getScore();
}
