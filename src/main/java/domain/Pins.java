package domain;

public class Pins {
    private static final int TEN_PINS = 10;
    private static final int NO_PINS = 0;
    private static final String PIPE = "|";
    private static final String GUTTER = "-";
    private static final String SPARE = "/";
    private static final String STRIKE = "x";

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

    public static boolean isEmpty(Pins pins) {
        return pins == null;
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

    public boolean isGutter() {
        return falledPins == NO_PINS;
    }

    public boolean isTotal(Pins secondPins) {
        if (this.falledPins + secondPins.falledPins > 10) {
            throw new IllegalArgumentException("핀의 합개는 10을 넘을 수 없습니다." + this.falledPins + " " + secondPins.falledPins);
        }
        return true;
    }

    public String print() {
        if (this.isStrike()) {
            return STRIKE;
        }
        if (isGutter()) {
            return GUTTER + PIPE;
        }
        return falledPins + PIPE;
    }

    public String print(Pins secondPins) {
        String first = String.valueOf(this.falledPins);
        String second = String.valueOf(secondPins.falledPins);

        if (this.isGutter()) {
            first = GUTTER;
        }
        if (secondPins.isGutter()) {
            second = GUTTER;
        }
        if (this.isSpare(secondPins)) {
            return first + PIPE + SPARE;
        }
        return first + PIPE + second;
    }
}
