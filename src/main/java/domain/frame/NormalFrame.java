package domain.frame;

import domain.score.Pin;
import domain.score.PinType;
import domain.score.State;

import java.util.Optional;

public class NormalFrame extends Frame {

    NormalFrame(Pin first) {
        super(first, 1);
    }

    NormalFrame(State state, int frameNo) {
        super(frameNo);
        this.state = state;
    }

    @Override
    public boolean isFinish() {
        return state.getType() != PinType.NOT_FINISH;
    }

    @Override
    public Optional<Frame> bowl(Pin pin) {
        if (isFinish()) {
            next = getNextFrame(state.bowl(pin));
            return Optional.of(next);
        }
        this.state = state.bowl(pin);
        return Optional.of(this);
    }

    @Override
    public Optional<Integer> getFrameScore() {
        return state.getTotalScore();
    }

    private Frame getNextFrame(State state) {
        if (frameNo == 9) {
            return new FinalFrame(state);
        }
        return new NormalFrame(state, frameNo + 1);
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
