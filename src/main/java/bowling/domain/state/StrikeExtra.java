package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public class StrikeExtra extends State {
    private Pin extraPin;

    public StrikeExtra(Pin fallenPin) {
        this.extraPin = fallenPin;
    }

    @Override
    public State bowlBall(Pin fallenPin) {
        return new StrikeFinal(extraPin, fallenPin);
    }

    @Override
    public boolean isFrameEnd() {
        return false;
    }

    @Override
    public String toFrameView() {
        return String.format("X%s ", extraPin.toString());
    }

    @Override
    public Score getScore() {
        return new Score(10 + extraPin.toIntValue(), 1);
    }

    @Override
    public Score addScore(Score score) {
        score = score.bowl(10);

        if(score.calculable())
            return score;

        return score.bowl(extraPin.toIntValue());
    }
}
