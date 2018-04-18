package domain.frame.pin;

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

    public static boolean isMax(int num) {
        return num == MAX;
    }

    public boolean isTotalMax(int num) {
        return this.num + num == MAX;
    }

    public int getNum() {
        return num;
    }

    public static boolean isValidRange(int num) {
        return num >= MIN && num <= MAX;
    }

    public boolean isOverRecordPin(int num) {
        return this.num + num > MAX;
    }

    public int getTotal(Pin otherPin) {
        return this.num + otherPin.num;
    }









    @Deprecated
    public boolean isMax() {
        return this.num == MAX;
    }

    @Deprecated
    public boolean isMax(Pin lastBonusPin) {
        return this.num + lastBonusPin.num == MAX;
    }
}