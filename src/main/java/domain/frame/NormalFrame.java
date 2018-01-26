package domain.frame;

import domain.score.Finish;
import domain.score.Miss;
import domain.score.Pin;

import java.util.Optional;

public class NormalFrame extends Frame {

    NormalFrame(Pin first) {
        super(first, 1);
    }

    NormalFrame(Pin first, int frameNo) {
        super(first, frameNo);
    }

    @Override
    public boolean isFinish() {
        return state instanceof Finish;
    }

    @Override
    public Optional<Frame> bowl(Pin pin) {
        if (state instanceof Finish) {
            next = getNextFrame(pin);
            return Optional.of(next);
        }
        this.state = state.bowl(pin);
        return Optional.of(this);
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
    public Optional<Integer> calculateScoreWithBefore(Frame before) {
        if (before.isStrike() && this.isStrike()) {
            return Optional.empty();
        }
        if (before.isStrike()) {
            if (!this.isFinish()) {
                return Optional.empty();
            }
            int score = getFrameScore().orElse(10);
            return Optional.of(score + 10);
        }
        return Optional.of(10 + getFirstScore());
    }

    @Override
    public Optional<Integer> calculateScoreWithBefore(Frame f1, Frame f2) {
        if (f1.isStrike() && f2.isStrike()) {
            return Optional.of(10 + 10 + getFirstScore());
        }
        throw new IllegalArgumentException();
    }

    private Frame getNextFrame(Pin pin) {
        if (frameNo == 9) {
            return new FinalFrame(pin);
        }
        return new NormalFrame(pin, frameNo + 1);
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
