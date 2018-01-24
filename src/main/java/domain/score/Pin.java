package domain.score;

public class Pin {
    static final Pin ZERO = new Pin(0);
    static final Pin TEN = new Pin(10);

    private final int fallPins;

    public Pin(int fallPins) {
        if (fallPins < 0 || fallPins > 10) {
            throw new IllegalArgumentException();
        }
        this.fallPins = fallPins;
    }

    boolean isStrike() {
        return fallPins == 10;
    }

    Pin minus(Pin first) {
        return new Pin(fallPins - first.fallPins);
    }

    boolean isSpare(Pin first) {
        return fallPins + first.fallPins == 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Pin)) { return false; }

        Pin that = (Pin) o;

        return fallPins == that.fallPins;
    }

    @Override
    public int hashCode() {
        return fallPins;
    }

    @Override
    public String toString() {
        if (ScoreType.valueOf(this).isDisplay()) {
            return ScoreType.valueOf(this).getDisplay();
        }
        return String.valueOf(fallPins);
    }
}
