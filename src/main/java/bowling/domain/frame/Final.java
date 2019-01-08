package bowling.domain.frame;

import bowling.domain.*;
import bowling.domain.state.State;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Final implements Frame {

    private LinkedList<State> state;

    Final() {
        this.state = new LinkedList<>();
        this.state.add(State.of());
    }

    @Override
    public Frame bowl(Pin pin) {
        if (!isFinished()) {
            State nextState = state.getLast().bowl(pin);
            state.removeLast();
            state.addLast(nextState);
        }

        if (state.getFirst().getFalledTotalPin().isStrike())
            state.addLast(State.of());

        return this;
    }

    @Override
    public boolean isFinished() {
        if (!state.getFirst().isFinished())
            return false;

        if (!state.getFirst().getFalledTotalPin().isStrike())
            return true;

        return getTotalPins().size() >= 3;
    }

    @Override
    public Score getScore() {
        return state.stream()
                .filter(State::anyBowled)
                .map(State::getScore)
                .reduce(Score::add).orElseThrow(IllegalScoreException::new);
    }

    @Override
    public List<Pin> getPins() {
        return state.stream()
                .filter(State::anyBowled)
                .flatMap(state -> state.getFalledPins().stream())
                .collect(Collectors.toList());
    }

    @Override
    public int getFrameNumber() {
        return 10;
    }

    @Override
    public Symbol getSymbol() {
        return state.stream()
                .filter(State::anyBowled)
                .map(State::getSymbol)
                .reduce((Symbol::add)).orElseThrow(IllegalSymbolException::new);
    }

    private List<Pin> getTotalPins() {
        return state.stream().filter(State::anyBowled).flatMap(state -> state.getFalledPins().stream()).collect(Collectors.toList());
    }
}
