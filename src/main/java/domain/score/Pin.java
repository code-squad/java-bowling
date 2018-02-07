package domain.score;

public class Pin {
    public static final Pin ZERO = new Pin(0);
    public static final Pin TEN = new Pin(10);

    private final int fallPins;

    public Pin(int fallPins) {
        if (fallPins < 0 || fallPins > 10) {
            throw new IllegalArgumentException();
        }
        this.fallPins = fallPins;
    }

    Pin add(Pin p2) {
        return new Pin(p2.fallPins + this.fallPins);
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
        if (this.equals(TEN)) {
            return "X";
        }
        if (this.equals(ZERO)) {
            return "-";
        }
        return String.valueOf(fallPins);
    }
}
