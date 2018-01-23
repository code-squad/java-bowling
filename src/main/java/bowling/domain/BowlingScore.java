package bowling.domain;

import java.util.Arrays;

public enum BowlingScore {
    GUTTER,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    SPARE,
    STRIKE,
    MISS;

    private static final BowlingScore[] ENUMS = BowlingScore.values();

    public int getValue() {
        return this.ordinal();
    }

    public static BowlingScore of(Roll roll) {
        return Arrays.asList(ENUMS).stream()
                .filter(score -> roll.equals(score.getValue()))
                .findFirst().get();
    }

    @Override
    public String toString() {
        switch (this) {
            case GUTTER:
                return "-";
            case SPARE:
                return "/";
            case STRIKE:
                return "X";
            case ONE:
            case TWO:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
            case NINE:
                return String.valueOf(this.ordinal());
            default:
                return "";
        }
    }
}