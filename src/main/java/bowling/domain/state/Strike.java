package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public class Strike implements State {
    @Override
    public State bowlBall(Pin fallenPin) {
        return new StrikeExtra(fallenPin);
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

    @Override
    public Score addScore(Score score) {
        return score.bowl(10);
    }

}
