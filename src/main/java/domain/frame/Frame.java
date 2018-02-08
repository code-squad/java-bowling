package domain.frame;

import domain.score.Pin;
import domain.score.State;

import java.util.Optional;

public abstract class Frame {

    final int frameNo;

    State state;

    Frame(State state, int frameNo) {
        this.state = state;
        this.frameNo = frameNo;
    }

    public abstract Optional<Frame> bowl(Pin pin);

    public abstract Optional<Integer> getFrameScore();

}
