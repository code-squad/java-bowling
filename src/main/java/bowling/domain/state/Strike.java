package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.domain.Symbol;
import com.google.common.collect.Lists;

import java.util.List;

class Strike extends Finished {

    @Override
    public State bowl(Pin pin) {
        throw new AlreadyFinishedStateException();
    }

    @Override
    public boolean anyBowled() {
        return true;
    }

    @Override
    public Score getScore() {
        return Score.of(10, 2);
    }

    @Override
    public Pin getFalledTotalPin() {
        return Pin.of(10);
    }

    @Override
    public List<Pin> getFalledPins() {
        return Lists.newArrayList(Pin.of(10));
    }

    @Override
    public Symbol getSymbol() {
        return Symbol.of("X");
    }
}
