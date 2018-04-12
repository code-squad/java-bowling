package bowling.domain;

public class Ball {

    static final int TEN_PIN = 10;
    static final int ZERO_PIN = 0;
    private int pin;

    public Ball(int pin) {
        if (pin < ZERO_PIN || TEN_PIN < pin) {
            throw new IllegalArgumentException("핀의 개수가 맞지 않습니다.");
        }
        this.pin = pin;
    }

    public static Ball playOf(int pin) {
        return new Ball(pin);
    }

    public boolean isStrike() {
        return this.pin == TEN_PIN;
    }

    public boolean isSpare(Ball first) {
        return (first.pin + this.pin) == TEN_PIN;
    }

    public int getPin() {
        return pin;
    }

    public void secondPinCheckException(int secondPin) {
        if (pin + secondPin > 10) {
            throw new IllegalArgumentException("핀의 합계가 10을 초과 했습니다.");
        }
    }
}
