package domain.score;

public class Score {
    private final Pin first;

    private Pin second;

    private Pin left = Pin.TEN;

    public Score(Pin first) {
        this.first = first;
        this.left = left.minus(first);
        this.second = null;
    }

    public void addSecond(Pin second) {
        if (second == null) {
            throw new IllegalArgumentException();
        }
        this.left = left.minus(second);
        this.second = second;
    }

    public boolean isStrike() {
        return first.equals(Pin.TEN);
    }

    public boolean isSpare() {
        return second != null && left.equals(Pin.ZERO);
    }

    public boolean isFinish() {
        return isStrike() || second != null;
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
