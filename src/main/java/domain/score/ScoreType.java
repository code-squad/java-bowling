package domain.score;

import static domain.score.Pin.TEN;
import static domain.score.Pin.ZERO;

public enum ScoreType {
    STRIKE("X"),
    SPARE("/"),
    MISS(null),
    GUTTER("-"),
    NONE(null),
    UNDEFINED(null);

    private final String display;

    ScoreType(String display) {
        this.display = display;
    }

    static ScoreType valueOf(Pin pin) {
        if (pin.equals(TEN)) {
            return STRIKE;
        }
        if (pin.equals(ZERO)) {
            return GUTTER;
        }
        return NONE;
    }

    static ScoreType valueOf(Pin p1, Pin p2) {
        if (valueOf(p1) == STRIKE) {
            throw new IllegalArgumentException();
        }
        if (p1.add(p2).equals(TEN)) {
            return SPARE;
        }
        return MISS;
    }

    String getDisplay() {
        return display;
    }

    boolean isDisplay() {
        return display != null;
    }
}
