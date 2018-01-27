package domain.score;

import static domain.score.Pin.TEN;
import static domain.score.Pin.ZERO;

public enum PinType {
    STRIKE("X"),
    SPARE("/"),
    GUTTER("-"),
    MISS(null),
    NOT_FINISH(null),
    NONE(null);

    private final String display;

    PinType(String display) {
        this.display = display;
    }

    static PinType valueOf(Pin pin) {
        if (pin.equals(TEN)) {
            return STRIKE;
        }
        if (pin.equals(ZERO)) {
            return GUTTER;
        }
        return NONE;
    }

    String getDisplay() {
        return display;
    }

    boolean isDisplay() {
        return display != null;
    }
}
