package domain;

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

    public boolean isOverRecord(int otherNum) {
        return this.num + otherNum > MAX;
    }

    public boolean isFullRecord(Pin otherPin) {
        if (otherPin == null) {
            return this.num == MAX;
        }
        return this.num + otherPin.num == MAX;
    }

    public int calcTotal(Pin otherPin) {
        if (otherPin == null) {
            return this.num;
        }
        return this.num + otherPin.num;
    }

    public int calcTotal(int otherNum) {
        return this.num + otherNum;
    }
}