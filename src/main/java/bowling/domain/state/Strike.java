package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public class Strike extends State {
    @Override
    public State bowlBall(Pin fallenPin) {
        return this;
    }

    @Override
    public boolean isFrameEnd() {
        return true;
    }

    @Override
    public String toFrameView() {
        return "X  ";
    }

    @Override
    public Score getScore() {
        return new Score(10, 2);
    }

}
