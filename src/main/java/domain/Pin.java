package domain;

import java.util.List;

public class Pin {
    public static final int MIN = 0;
    public static final int MAX = 10;
    private int num;

    public Pin(int num) {
        if (!isValidRange(num)) {
            throw new IllegalArgumentException("유효하지않은 범위의 개수입니다");
        }
        this.num = num;
    }

    public static boolean isValidRange(int score) {
        return score >= MIN && score <= MAX;
    }

    public static boolean isFullPinNumRecord(List<Pin> pins) {
        return pins.stream().mapToInt(pinInstance -> pinInstance.num).sum() == MAX;
    }

    public boolean isOverRecord(List<Pin> pins) {
        int existingSum = pins.stream().mapToInt(pinInstance -> pinInstance.num).sum();
        return existingSum + this.num > MAX;
    }
}