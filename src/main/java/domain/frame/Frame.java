package domain.frame;

import domain.score.Pin;
import domain.score.Ready;
import domain.score.State;

import java.util.Optional;

public abstract class Frame {

    final int frameNo;

    Frame next;

    State state;

    public Frame(int frameNo) {
        this.frameNo = frameNo;
    }

    Frame(Pin first, int frameNo) {
        this.state = Ready.getInstance().bowl(first);
        this.frameNo = frameNo;
    }

    public abstract boolean isFinish();

    public abstract Optional<Frame> bowl(Pin pin);

    public abstract Optional<Integer> getFrameScore();

}
