package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.domain.Symbol;
import com.google.common.collect.Lists;

import java.util.List;

class Miss extends Finished {

    private final Pin firstPin;
    private final Pin secondPin;

    Miss(Pin firstPin, Pin secondPin) {
        this.firstPin = firstPin;
        this.secondPin = secondPin;
    }

    @Override
    public State bowl(Pin pin) {
        throw new AlreadyFinishedStateException();
    }

    @Override
    public Score getScore() {
        return Score.of(getFalledTotalPin().getPin(), 0);
    }

    @Override
    public Pin getFalledTotalPin() {
        return firstPin.add(secondPin);
    }

    @Override
    public List<Pin> getFalledPins() {
        return Lists.newArrayList(firstPin, secondPin);
    }

    @Override
    public Symbol getSymbol() {
        return Symbol.of(firstPin.getPin()).add(Symbol.of("|")).add(Symbol.of(secondPin.getPin()));
    }
}
