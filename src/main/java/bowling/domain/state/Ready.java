package bowling.domain.state;

import bowling.domain.*;

import java.util.List;

class Ready extends Running {

    @Override
    public State bowl(Pin pin) {
        if (!isBowlable(pin))
            throw new IllegalPinException();

        if (pin.isStrike())
            return new Strike();

        return new FirstBowl(pin);
    }

    @Override
    public boolean isBowlable(Pin pin) {
        return 0 <= pin.getPin() && pin.getPin() <= 10;
    }

    @Override
    public boolean anyBowled() {
        return false;
    }

    @Override
    public Score getScore() {
        throw new IllegalScoreException();
    }

    @Override
    public Pin getFalledTotalPin() {
        throw new IllegalPinException();
    }

    @Override
    public List<Pin> getFalledPins() {
        throw new IllegalPinException();
    }

    @Override
    public Symbol getSymbol() {
        throw new IllegalSymbolException();
    }
}
