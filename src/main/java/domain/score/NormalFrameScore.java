package domain.score;

import java.util.Optional;

public class NormalFrameScore extends FrameScore {

    public NormalFrameScore(Pin first) {
        super(first);
    }

    @Override
    public boolean isFinish() {
        return state instanceof Finish;
    }

    @Override
    public void bowl(Pin pin) {
        this.state = state.bowl(pin);
    }

    @Override
    public Optional<Integer> getFrameScore() {
        if (state instanceof Miss) {
            return getSumOfFirstAndSecondScore();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getSumOfFirstAndSecondScore() {
        if (state instanceof Finish) {
            return state.getTotalScore();
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
