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
        return !state.isLeft();
    }

    @Override
    public Optional<Frame> bowl(Pin pin) {
        if (isFinish()) {
            throw new IllegalStateException();
        }
        State next = state.bowl(pin);
        if (!state.isFinish()) {
            this.state = next;
        }
        return returnEmptyIfFinish();
    }

    @Override
    public Optional<Integer> getFrameScore() {
        return state.getTotalScore();
    }

    private Optional<Frame> returnEmptyIfFinish() {
        if (isFinish()) {
            return Optional.empty();
        }
        return Optional.of(this);
    }

    @Override
    public String toString() {
        if (!state.getNext().isPresent()) {
            return state.toString();
        }
        if (!state.getNext().get().getNext().isPresent()) {
            return state.toString() + "|" + state.getNext().get().toString();
        }
        return state.toString() + "|" + state.getNext().get().toString() + "|" + state.getNext().get().getNext().get().getScore();
    }
}
