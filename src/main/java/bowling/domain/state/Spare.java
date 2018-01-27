package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public class Spare implements State {
    private Pin firstFallenPin;
    private Pin secondFallenPin;

    public Spare(Pin firstFallenPin, Pin secondFallenPin) {
        this.firstFallenPin = firstFallenPin;
        this.secondFallenPin = secondFallenPin;
    }

    @Override
    public State bowlBall(Pin fallenPin) {
        return new SpareFinal(firstFallenPin, secondFallenPin, fallenPin);
    }

    @Override
    public boolean isFrameEnd() {
        return true;
    }

    @Override
    public String toFrameView() {
        return String.format("%s|/", firstFallenPin.toString());
    }

    @Override
    public Score getScore() {
        return new Score(10, 1);
    }

    @Override
    public Score addScore(Score score) {
        score = score.bowl(firstFallenPin.toIntValue());
        if(score.calculable())
            return score;

        return score.bowl(secondFallenPin.toIntValue());
    }
}
