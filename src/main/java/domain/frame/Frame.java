package domain.frame;

import domain.score.Pin;
import domain.score.Score;

import java.util.Optional;

public abstract class Frame {
    private final Score score;

    Frame(Score score) {
        if (score == null) {
            throw new IllegalArgumentException();
        }
        this.score = score;
    }

    void addResult(Pin pin) {
        this.score.addResult(pin);
    }

    boolean isFinish() {
        return score.isFinish();
    }

    boolean isStrike() {
        return score.isStrike();
    }

    Optional<Integer> calculateScore() {
        return score.getFrameScore();
    }

    Integer getFirstScore() {
        return score.getFirstScore();
    }

    Optional<Integer> getSecondScore() {
        return score.getSumOfScore();
    }

    abstract Optional<Integer> calculateAdditionalScore(Frame... f);

    @Override
    public String toString() {
        return String.format("%-4s", score.toString());
    }
}
