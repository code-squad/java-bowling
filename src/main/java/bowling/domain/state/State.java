package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.domain.Symbol;

import java.util.List;

public interface State {

    State bowl(Pin pin);

    boolean isBowlable(Pin pin);

    boolean isFinished();

    boolean anyBowled();

    Score getScore();

    Pin getFalledTotalPin();

    List<Pin> getFalledPins();

    Symbol getSymbol();

    static State of() {
        return new Ready();
    }
}
