package domain.frame;

import domain.score.Pin;
import domain.score.State;

import java.util.Optional;

public class FinalFrame extends Frame {

    FinalFrame(Pin first) {
        super(first, 10);
    }

    FinalFrame(State state) {
        super(10);
        this.state = state;
    }

    @Override
    public boolean isFinish() {
        return state.getTotalScore().isPresent();
    }

    @Override
    public Optional<Frame> bowl(Pin pin) {
        if (!state.isLeft()) {
            throw new IllegalStateException();
        }
        state.bowl(pin);
        return returnEmptyIfFinish();
    }

    @Override
    public Optional<Integer> getFrameScore() {
        return state.getTotalScore();
    }

    private Optional<Frame> returnEmptyIfFinish() {
        if (!state.isLeft()) {
            return Optional.empty();
        }
        return Optional.of(this);
    }

    @Override
    public String toString() {
        if (!state.getNext().isPresent()) {
            return state.toString();
        }
        return state.toString() + "|" + state.getNext().get().toString();
    }
}
