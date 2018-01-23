package model;

import java.util.Arrays;

public enum Score {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    STRIKE("X"),
    SPARE("/"),
    GUTTER("-");

    private String value;

    Score(String value) {
        this.value = value;
    }

    public static Score valueOf(Integer numberOfFallingPins, Integer totalNumberOfPins) {
        if ((totalNumberOfPins - numberOfFallingPins) < 0){
            throw new IllegalArgumentException("한 프레임 당 볼링 핀의 수는 10개 입니다.");
        }
        if (totalNumberOfPins.equals(10) && numberOfFallingPins.equals(10)) {
            return STRIKE;
        }
        if (isSame(numberOfFallingPins - totalNumberOfPins, 0)) {
            return SPARE;
        }
        if (isSame(numberOfFallingPins, 0)) {
            return GUTTER;
        }

        return Arrays.stream(Score.values())
                     .filter(score -> score.value.equals(String.valueOf(numberOfFallingPins)))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException());
    }

    public static String of(Score score) {
        return score.value;
    }

    private static boolean isSame(Integer value, Integer shouldBe) {
        return value.equals(shouldBe);
    }
}
