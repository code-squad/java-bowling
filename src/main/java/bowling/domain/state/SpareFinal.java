package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public class SpareFinal implements State {
    private Pin firstFallenPin;
    private Pin secondFallenPin;
    private Pin lastPin;

    public SpareFinal(Pin firstFallenPin, Pin secondFallenPin, Pin lastPin) {
        this.firstFallenPin = firstFallenPin;
        this.secondFallenPin = secondFallenPin;
        this.lastPin = lastPin;
    }

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
        return String.format("%s/%s", firstFallenPin.toString(), lastPin.toString());
    }

    @Override
    public Score getScore() {
        return new Score(firstFallenPin.toIntValue() + secondFallenPin.toIntValue() + lastPin.toIntValue(), 0);
    }

    @Override
    public Score addScore(Score score) {
        score = score.bowl(firstFallenPin.toIntValue());

        if(score.calculable())
            return score;

        return score.bowl(secondFallenPin.toIntValue());
    }
}
