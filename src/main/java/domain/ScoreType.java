package domain;

import static domain.ScoreNumber.TEN;
import static domain.ScoreNumber.ZERO;

public enum ScoreType {
    STRIKE("X"),
    SPARE("/"),
    MISS(null),
    GUTTER("-"),
    NONE(null);

    private final String display;

    ScoreType(String display) {
        this.display = display;
    }

    public static ScoreType valueOf(ScoreNumber first, ScoreNumber second) {
        if (first.equals(TEN)) {
            throw new IllegalArgumentException();
        }
        if (first.sum(second).equals(TEN)) {
            return SPARE;
        }
        if (second.equals(ZERO)) {
            return GUTTER;
        }
        return MISS;
    }

    public static ScoreType valueOf(ScoreNumber score) {
        if (score.equals(TEN)) {
            return STRIKE;
        }
        if (score.equals(ZERO)) {
            return GUTTER;
        }
        return NONE;
    }

    public String getDisplay() {
        return display;
    }

    public boolean isDisplay() {
        return this.getDisplay() != null;
    }
}
