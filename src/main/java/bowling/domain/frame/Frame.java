package bowling.domain.frame;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.domain.Symbol;

import java.util.List;

public interface Frame {

    Frame bowl(Pin pin);

    boolean isFinished();

    Score getScore();

    List<Pin> getPins();

    int getFrameNumber();

    Symbol getSymbol();

    static Frame of() {
        return new Normal(1);
    }
}
