package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.exception.CannotCalculateException;

public class FirstBowl implements State {
    private Pin fallenPin;

    public FirstBowl(Pin fallenPin) {
        if(fallenPin == null)
            throw new IllegalArgumentException("Invalid try, first try is not attempted");

        this.fallenPin = fallenPin;
    }

    @Override
    public State bowlBall(Pin secondFallenPin) {
        if(secondFallenPin == null || fallenPin.isOverTen(secondFallenPin))
            throw new IllegalArgumentException("SecondTry num make total pin over 10");

        if(fallenPin.isSpare(secondFallenPin))
            return new Spare(fallenPin, secondFallenPin);

        return new Miss(fallenPin, secondFallenPin);
    }

    @Override
    public boolean isFrameEnd() {
        return false;
    }

    @Override
    public String toFrameView() {
        return String.format("%-3s", fallenPin.toString());
    }

    @Override
    public Score getScore() {
        throw new CannotCalculateException();
    }

    @Override
    public Score addScore(Score score) {
        return score.bowl(fallenPin.toIntValue());
    }

}
