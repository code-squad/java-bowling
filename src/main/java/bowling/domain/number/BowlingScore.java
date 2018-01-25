package bowling.domain.number;

import java.util.Arrays;

public enum BowlingScore {
    GUTTER("-"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    SPARE("/"),
    STRIKE("X"),
    MISS("");

    private static final BowlingScore[] ENUMS = BowlingScore.values();
    private String string;


    BowlingScore(String string) {
        this.string = string;
    }

    public int getValue() {
        return this.ordinal();
    }

    public static BowlingScore of(Roll roll) {
        return Arrays.asList(ENUMS).stream()
                .filter(score -> roll.equals(score.getValue()))
                .findFirst().get();
    }

    public String getString() {
        return string;
    }
}