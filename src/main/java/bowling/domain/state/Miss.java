package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public class Miss implements State {
    private Pin firstFallenPin;
    private Pin secondFallenPin;

    public Miss(Pin firstFallenPin, Pin secondFallenPin) {
        this.firstFallenPin = firstFallenPin;
        this.secondFallenPin = secondFallenPin;
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
        return String.format("%s|%s", firstFallenPin.toString(), secondFallenPin.toString());
    }

    @Override
    public Score getScore() {
        return new Score(firstFallenPin.add(secondFallenPin), 0);
    }

    @Override
    public Score addScore(Score score) {
        score = score.bowl(firstFallenPin.toIntValue());
        if(score.calculable())
            return score;

        return score.bowl(secondFallenPin.toIntValue());
    }

}
