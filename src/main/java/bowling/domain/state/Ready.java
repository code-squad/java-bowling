package bowling.domain.state;

import bowling.domain.Pin;

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
    public boolean isCalculable() {
        return false;
    }
}
