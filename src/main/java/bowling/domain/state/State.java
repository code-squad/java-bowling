package bowling.domain.state;

import bowling.domain.Pin;

public abstract class State {
    public abstract State bowlBall(Pin fallenPin);
    public abstract boolean isFrameEnd();
    public abstract String toFrameView();
}
