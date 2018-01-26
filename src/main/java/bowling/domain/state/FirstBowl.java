package bowling.domain.state;

import bowling.domain.Pin;

public class FirstBowl extends State {
    private Pin fallenPin;

    public FirstBowl(Pin fallenPin) {
        this.fallenPin = fallenPin;
    }

    @Override
    public State bowlBall(Pin secondFallenPin) {
        if(fallenPin.isSpare(secondFallenPin))
            return new Spare(fallenPin, secondFallenPin);

        return new Miss(fallenPin, secondFallenPin);
    }

    @Override
    public boolean isFrameEnd() {
        return false;
    }
}
