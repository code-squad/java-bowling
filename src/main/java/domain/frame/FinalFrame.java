package domain.frame;

import domain.score.Bonus;
import domain.score.Finish;
import domain.score.Miss;
import domain.score.Pin;
import domain.score.State;
import domain.score.Strike;

import java.util.Optional;

public class FinalFrame extends Frame {

    private State bonus;

    FinalFrame(Pin first) {
        super(first, 10);
    }

    @Override
    public boolean isFinish() {
        if (state instanceof Miss) {
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
        if (!(state instanceof Finish)) {
            this.state = state.bowl(pin);
            return Optional.of(this);
        }
        if (bonus != null) {
            this.bonus = bonus.bowl(pin);
            return Optional.empty();
        }
        bonus = new Bonus(state, pin);
        if (state instanceof Strike) {
            return Optional.of(this);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getFrameScore() {
        if (state instanceof Miss) {
            return state.getTotalScore();
        }
        if (state instanceof Finish && bonus != null) {
            return bonus.getTotalScore()
                        .map(i -> i + state.getTotalScore().orElseThrow(IllegalStateException::new));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> getSumOfFirstAndSecondScore() {
        if (!(state instanceof Finish)) {
            return Optional.empty();
        }
        if (state instanceof Strike) {
            if (bonus == null) {
                return Optional.empty();
            }
            return state.getTotalScore()
                        .map(i -> i + bonus.getFirstScore());
        }
        return state.getTotalScore();
    }

    @Override
    public Optional<Integer> calculateScoreWithBefore(Frame f1, Frame f2) {
        if (!f1.isStrike() || !f2.isStrike()) {
            throw new IllegalArgumentException();
        }
        return Optional.of(getFirstScore() + 20);
    }

    @Override
    public Optional<Integer> calculateScoreWithBefore(Frame before) {
        if (before.isStrike()) {
            return getSumOfFirstAndSecondScore().map(integer -> integer + 10);
        }
        return Optional.of(getFirstScore() + 10);
    }

    @Override
    public String toString() {
        if (bonus == null) {
            return state.toString();
        }
        return state.toString() + "|" + bonus.toString();
    }
}
