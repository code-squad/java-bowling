package bowling.frame.state;

import bowling.frame.pin.Pins;
import bowling.frame.pin.Score;

public interface State {
    State bowl(Pins falledPins);

    boolean isFinish();

    Score getScore();

    Score calculateAdditionalScore(Score score);

    String getDesc();
}
