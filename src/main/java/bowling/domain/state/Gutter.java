package bowling.domain.state;

import bowling.domain.IllegalSymbolException;
import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.domain.Symbol;
import com.google.common.collect.Lists;

import java.util.List;

class Gutter extends Finished {

    private final Pin firstPin;
    private final Pin secondPin;

    Gutter(Pin firstPin, Pin secondPin) {
        this.firstPin = firstPin;
        this.secondPin = secondPin;
    }

    @Override
    public State bowl(Pin pin) {
        throw new AlreadyFinishedStateException();
    }

    @Override
    public Score getScore() {
        return Score.of(firstPin.add(secondPin).getPin(), 0);
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
        if (firstPin.isGutter() && secondPin.isGutter())
            return Symbol.of("-|-");

        if (firstPin.isGutter())
            return Symbol.of("-|").add(Symbol.of(secondPin.getPin()));

        if (secondPin.isGutter())
            return Symbol.of(firstPin.getPin()).add(Symbol.of("|-"));

        throw new IllegalSymbolException();
    }
}
