package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;

public interface State {
    State bowlBall(Pin fallenPin);
    boolean isFrameEnd();
    String toFrameView();
    Score getScore();
    Score addScore(Score score);
}
