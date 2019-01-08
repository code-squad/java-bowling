package bowling.domain.frame;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.domain.Symbol;
import bowling.domain.state.State;
import com.google.common.collect.Lists;

import java.util.List;

class Normal implements Frame {

    private static final int MAX = 9;
    private static final int MIN = 1;

    private State state;
    private int frameNumber;

    Normal(int frameNumber) {
        this.frameNumber = frameNumber;
        this.state = State.of();

        if (!isValid())
            throw new InvalidFrameException();
    }

    @Override
    public Frame bowl(Pin pin) {
        state = state.bowl(pin);

        if (!isFinished()) {
            return this;
        }

        if (MAX == frameNumber)
            return new Final();

        return new Normal(frameNumber + 1);
    }

    private boolean isValid() {
        return MIN <= frameNumber && frameNumber <= MAX;
    }

    @Override
    public boolean isFinished() {
        return state.isFinished();
    }

    @Override
    public Score getScore() {
        return state.getScore();
    }

    @Override
    public List<Pin> getPins() {
        return Lists.newArrayList(state.getFalledPins());
    }

    @Override
    public int getFrameNumber() {
        return frameNumber;
    }

    @Override
    public Symbol getSymbol() {
        return state.getSymbol();
    }
}
