package bowling.domain.state;

import bowling.domain.Pin;

public class Strike extends State {
    @Override
    public State bowlBall(Pin fallenPin) {
        return this;
    }

    @Override
    public boolean isFrameEnd() {
        return true;
    }
}
