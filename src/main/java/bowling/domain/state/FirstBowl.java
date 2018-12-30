package bowling.domain.state;

import bowling.domain.IllegalPinException;
import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.domain.Symbol;
import com.google.common.collect.Lists;

import java.util.List;

class FirstBowl extends Running {

    private final Pin pin;

    FirstBowl(Pin pin) {
        this.pin = pin;
    }

    @Override
    public State bowl(Pin pin) {
        if (!isBowlable(pin))
            throw new IllegalPinException();

        if (this.pin.isSpare(pin))
            return new Spare(this.pin, pin);

        if (this.pin.isGutter() || pin.isGutter())
            return new Gutter(this.pin, pin);

        return new Miss(this.pin, pin);
    }

    @Override
    public boolean isBowlable(Pin pin) {
        int totalPin = this.pin.add(pin).getPin();
        return 0 <= totalPin && totalPin <= 10;
    }

    @Override
    public boolean anyBowled() {
        return true;
    }

    @Override
    public Score getScore() {
        return Score.of(pin.getPin(), 0);
    }

    @Override
    public Pin getFalledTotalPin() {
        return pin;
    }

    @Override
    public List<Pin> getFalledPins() {
        return Lists.newArrayList(pin);
    }

    @Override
    public Symbol getSymbol() {
        return Symbol.of(pin.getPin());
    }
}
