package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.exception.CannotCalculateException;

public class Ready extends State{

    @Override
    public State bowlBall(Pin fallenPin) {
        if(fallenPin.isStrike())
            return new Strike();

        return new FirstBowl(fallenPin);
    }

    @Override
    public boolean isFrameEnd() {
        return false;
    }

    @Override
    public String toFrameView() {
        return "   ";
    }

    @Override
    public Score getScore() {
        throw new CannotCalculateException();
    }

    @Override
    public Score addScore(Score score) {
        throw new CannotCalculateException();
    }

}
