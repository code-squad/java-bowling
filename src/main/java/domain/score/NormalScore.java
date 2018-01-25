package domain.score;

import java.util.Optional;

public class NormalScore implements Score {
    private final Pin first;

    private Pin second;

    private Pin left = Pin.TEN;

    public NormalScore(Pin first) {
        this.first = first;
        this.left = left.minus(first);
        this.second = null;
    }

    @Override
    public void addResult(Pin second) {
        if (second == null) {
            throw new IllegalArgumentException();
        }
        this.left = left.minus(second);
        this.second = second;
    }

    @Override
    public boolean isFinish() {
        return isStrike() || second != null;
    }

    @Override
    public Optional<Integer> getTotalScore() {
        if (!canCalculate()) {
            return Optional.empty();
        }
        if (isStrike()) {
            return Optional.of(10);
        }
        return Optional.of(first.toInt() + second.toInt());
    }

    @Override
    public boolean isStrike() {
        return first.equals(Pin.TEN);
    }

    @Override
    public Integer getFirstScore() {
        return first.toInt();
    }

    @Override
    public Optional<Integer> getSecondScore() {
        return Optional.of(second.toInt());
    }

    private boolean canCalculate() {
        return !isStrike() && second != null && !second.isSpare(first);
    }

    private boolean isSpare() {
        return second != null && left.equals(Pin.ZERO);
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
