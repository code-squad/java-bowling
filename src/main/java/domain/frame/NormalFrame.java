package domain.frame;

import domain.score.NormalScore;
import domain.score.Pin;

import java.util.Optional;

class NormalFrame extends Frame {

    NormalFrame(Pin pin) {
        super(new NormalScore(pin));
    }

    @Override
    Optional<Integer> calculateAdditionalScore(Frame... f) {
        if (f.length != 1 && f.length != 2) {
            throw new IllegalArgumentException();
        }
        if (f.length == 1) {
            return calculateScoreWithBefore(f[0]);
        }
        return calculateScoreWithBefore(f[0], f[1]);
    }

    private Optional<Integer> calculateScoreWithBefore(Frame before) {
        if (before.isStrike() && this.isStrike()) {
            return Optional.empty();
        }
        if (before.isStrike()) {
            if (!this.isFinish()) {
                return Optional.empty();
            }
            int score = calculateScore().orElse(10);
            return Optional.of(score + 10);
        }
        return Optional.of(10 + getFirstScore());
    }

    private Optional<Integer> calculateScoreWithBefore(Frame f1, Frame f2) {
        if (f1.isStrike() && f2.isStrike()) {
            return Optional.of(10 + 10 + getFirstScore());
        }
        throw new IllegalArgumentException();
    }
}
