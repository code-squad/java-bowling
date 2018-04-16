package domain;

public class Pins {
    private static final int TEN_PINS = 10;
    private static final int NO_PINS = 0;

    int falledPins;

    public Pins(int falledPins) {
        isValid(falledPins);
        this.falledPins = falledPins;
    }

    public boolean isValid(int falledPins) {
        if ( falledPins < 0 || falledPins > 10) {
            throw new RuntimeException("쓰러진 핀의 개수는 0부터 10사이여야 합니다.");
        }
        return true;
    }

    public boolean isStrike() {
        return falledPins == TEN_PINS;
    }

    public boolean isSpare(Pins secondPins) {
        return this.falledPins + secondPins.falledPins == TEN_PINS;
    }

    public boolean isOpen(Pins secondPins) {
        return this.falledPins + secondPins.falledPins < TEN_PINS;
    }

    public boolean isTotal(Pins secondPins) {
        if (this.falledPins + secondPins.falledPins > 10) {
            throw new IllegalArgumentException("핀의 합개는 10을 넘을 수 없습니다.");
        }
        return true;
    }

    @Override
    public String toString() {
        if (falledPins == NO_PINS) {
            return "-";
        }
        return String.valueOf(falledPins);
    }
}
