package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.domain.Symbol;
import com.google.common.collect.Lists;

import java.util.List;

class Spare extends Finished {

    private final Pin firstPin;
    private final Pin secondPin;

    Spare(Pin firstPin, Pin secondPin) {
        this.firstPin = firstPin;
        this.secondPin = secondPin;
    }

    @Override
    public State bowl(Pin pin) {
        throw new AlreadyFinishedStateException();
    }

    @Override
    public Score getScore() {
        return Score.of(10, 1);
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
        return Symbol.of(firstPin.getPin()).add(Symbol.of("|/"));
    }
}
