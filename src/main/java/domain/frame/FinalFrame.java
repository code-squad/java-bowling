package domain.frame;

import domain.score.Pin;
import domain.score.State;

import java.util.Optional;

public class FinalFrame extends Frame {

    FinalFrame(State state) {
        super(state, 10);
    }

    @Override
    public Optional<Frame> bowl(Pin pin) {
        if (!state.isLeft()) {
            throw new IllegalStateException();
        }
        State next = state.bowl(pin);
        if (!state.isFinish()) {
            this.state = next;
        }
        return returnEmptyIfFrameFinished();
    }

    @Override
    public Optional<Integer> getFrameScore() {
        return state.getTotalScore();
    }

    private Optional<Frame> returnEmptyIfFrameFinished() {
        if (!state.isLeft()) {
            return Optional.empty();
        }
        return Optional.of(this);
    }

    @Override
    public String toString() {
        if (state.hasNext()) {
            State next = state.getNext().orElseThrow(IllegalStateException::new);
            if (next.hasNext()) {
                State nextOfNext = next.getNext().orElseThrow(IllegalStateException::new);
                return state.toString() + "|" + next.toString() + "|" + nextOfNext.getScore();
            }
            return state.toString() + "|" + next.toString();
        }
        return state.toString();
    }
}
