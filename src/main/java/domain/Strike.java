package domain;

public class Strike extends Status {
    private Pins falledPins;

    public Strike(Pins falledPins) {
        this.falledPins = falledPins;
    }

    @Override
    public String toString() {
        return "x";
    }
}
