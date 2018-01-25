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

    Pin minus(Pin first) {
        return new Pin(fallPins - first.fallPins);
    }

    Pin add(Pin p2) {
        return new Pin(p2.fallPins + this.fallPins);
    }

    boolean isStrike() {
        return ScoreType.valueOf(this) == ScoreType.STRIKE;
    }

    boolean isSpare(Pin p) {
        if (this.isStrike()) {
            return false;
        }
        return ScoreType.valueOf(this, p) == ScoreType.SPARE;
    }

    int toInt() {
        return fallPins;
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
