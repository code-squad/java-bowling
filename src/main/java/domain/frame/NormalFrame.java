package domain.frame;

import domain.score.Pin;
import domain.score.State;

import java.util.Optional;

public class NormalFrame extends Frame {

    NormalFrame(State first) {
        super(first, 1);
    }

    private NormalFrame(State state, int frameNo) {
        super(state, frameNo);
    }

    @Override
    public Optional<Frame> bowl(Pin pin) {
        if (state.isFinish()) {
            return Optional.of(getNextFrame(state.bowl(pin)));
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
