package domain.score;

import java.util.Optional;

public class FinalFrameScore extends FrameScore {

    private State bonus;

    public FinalFrameScore(Pin first) {
        super(first);
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
    public void bowl(Pin pin) {
        if (isFinish()) {
            throw new IllegalArgumentException();
        }
        if (!(state instanceof Finish)) {
            this.state = state.bowl(pin);
            return;
        }
        if (bonus != null) {
            this.bonus = bonus.bowl(pin);
            return;
        }
        bonus = new Bonus(state, pin);
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
    public String toString() {
        if (bonus == null) {
            return state.toString();
        }
        return state.toString() + "|" + bonus.toString();
    }
}
