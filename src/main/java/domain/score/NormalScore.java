package domain.score;

import java.util.Optional;

public class NormalScore extends Score {

    public NormalScore(Pin first) {
        super(first);
        this.second = null;
    }

    @Override
    public boolean isFinish() {
        return isStrike() || second != null;
    }

    @Override
    public void addResult(Pin second) {
        if (second == null) {
            throw new IllegalArgumentException();
        }
        this.first.add(second);
        this.second = second;
    }

    @Override
    public Optional<Integer> getFrameScore() {
        if (!canCalculateFrameScore()) {
            return Optional.empty();
        }
        return Optional.of(first.toInt() + second.toInt());
    }

    @Override
    public Optional<Integer> getSumOfFirstAndSecondScore() {
        if (isStrike()) {
            return Optional.of(10);
        }
        if (second == null) {
            return Optional.empty();
        }
        return Optional.of(first.toInt() + second.toInt());
    }

    private boolean canCalculateFrameScore() {
        return !isStrike() && second != null && !isSpare();
    }

    private boolean isSpare() {
        return second != null && first.isSpare(second);
    }

    @Override
    public String toString() {
        if (isStrike()) {
            return ScoreType.STRIKE.getDisplay();
        }
        if (isSpare()) {
            return first.toString() + "|" + ScoreType.SPARE.getDisplay();
        }
        if (second == null) {
            return first.toString();
        }
        return first.toString() + "|" + second.toString();
    }
}
