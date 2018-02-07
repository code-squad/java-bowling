package domain.frame;

import domain.score.Bonus;
import domain.score.Pin;
import domain.score.PinType;
import domain.score.State;

import java.util.Optional;

public class FinalFrame extends Frame {

    private State bonus;


    FinalFrame(Pin first) {
        super(first, 10);
    }

    FinalFrame(State state) {
        super(10);
        this.state = state;
    }

    @Override
    public boolean isFinish() {
        if (state.getType() == PinType.MISS) {
            return true;
        }

        return bonus != null && bonus.getTotalScore()
                                     .isPresent();
    }

    @Override
    public Optional<Frame> bowl(Pin pin) {
        if (isFinish()) {
            throw new IllegalArgumentException();
        }
        if (state.getType() == PinType.NOT_FINISH) {
            this.state = state.bowl(pin);
            return returnEmptyIfFinish();
        }
        if (bonus != null) {
            this.bonus = bonus.bowl(pin);
            return returnEmptyIfFinish();
        }
        bonus = new Bonus(state, pin);
        return returnEmptyIfFinish();
    }

    @Override
    public Optional<Integer> getFrameScore() {
        if (state.getType() == PinType.MISS) {
            return state.getTotalScore();
        }
        if (state.getType() != PinType.NOT_FINISH && bonus != null) {
            return bonus.getTotalScore()
                        .map(i -> i + state.getTotalScore().orElseThrow(IllegalStateException::new));
        }
        return Optional.empty();
    }

    private Optional<Frame> returnEmptyIfFinish() {
        if (isFinish()) {
            return Optional.empty();
        }
        return Optional.of(this);
    }

    @Override
    public String toString() {
        if (bonus == null) {
            return state.toString();
        }
        return state.toString() + "|" + bonus.toString();
    }
}
