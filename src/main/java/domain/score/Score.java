package domain.score;

import java.util.Optional;

public abstract class Score {

    final Pin first;

    Pin second;

    Score(Pin first) {
        if (first == null) {
            throw new IllegalArgumentException();
        }
        this.first = first;
    }

    public boolean isStrike() {
        return first.equals(Pin.TEN);
    }

    public Integer getFirstScore() {
        return first.toInt();
    }

    public abstract boolean isFinish();

    public abstract void addResult(Pin pin);

    public abstract Optional<Integer> getFrameScore();

    public abstract Optional<Integer> getSumOfScore();
}
