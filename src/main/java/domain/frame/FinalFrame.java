package domain.frame;

import domain.score.FinalFrameScore;
import domain.score.Pin;

import java.util.Optional;

class FinalFrame extends Frame {

    FinalFrame(Pin score) {
        super(new FinalFrameScore(score));
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

    private Optional<Integer> calculateScoreWithBefore(Frame f1, Frame f2) {
        if (!f1.isStrike() || !f2.isStrike()) {
            throw new IllegalArgumentException();
        }
        return Optional.of(getFirstScore() + 20);
    }

    private Optional<Integer> calculateScoreWithBefore(Frame before) {
        if (before.isStrike()) {
            return getSumOfScore().map(integer -> integer + 10);
        }
        return Optional.of(getFirstScore() + 10);
    }
}
