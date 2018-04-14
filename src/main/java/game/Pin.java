package game;

public class Pin {
    private int pinFall;
    private static  final int MAX_FALL = 10;
    private static  final int MIN_FALL = 0;

    public Pin(int pinFall) {
        if (pinFall > MAX_FALL || pinFall < MIN_FALL)
            throw new IllegalArgumentException("0~10개를 쓰러트릴 수 있습니다.");
        this.pinFall = pinFall;
    }

    public int getPinFall() {
        return pinFall;
    }

    public boolean checkFinish() {
        if (pinFall == MAX_FALL)
            return true;
        return false;
    }
}
