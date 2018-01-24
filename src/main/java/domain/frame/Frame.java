package domain.frame;

import domain.score.Pin;
import domain.score.Score;

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

    @Override
    public String toString() {
        return String.format("%-4s", score.toString());
    }
}
