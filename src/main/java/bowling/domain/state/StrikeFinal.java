package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public class StrikeFinal implements State {
    private Pin extraPin;
    private Pin lastPin;

    public StrikeFinal(Pin extraPin, Pin lastPin) {
        this.extraPin = extraPin;
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
        if(extraPin.isSpare(lastPin))
            return String.format("X%s/", extraPin.toString());

        return String.format("X%s%s", extraPin.toString(), lastPin.toString());
    }

    @Override
    public Score getScore() {
        return new Score(10 + extraPin.toIntValue() + lastPin.toIntValue(), 0);
    }

    @Override
    public Score addScore(Score score) {
        score = score.bowl(10);
        if(score.calculable())
            return score;
        
        return score.bowl(extraPin.toIntValue());
    }
}
