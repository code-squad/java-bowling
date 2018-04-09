package bowling.domain;

public class Ball {

    private int pin;

    public Ball(int pin) {
        if (pin < 0 || 10 < pin) {
            throw new IllegalArgumentException("핀의 개수가 맞지 않습니다.");
        }
        this.pin = pin;
    }

    public static Ball playOf(int pin) {
        return new Ball(pin);
    }

    public boolean isStrike() {
        return this.pin == 10;
    }

    public boolean isSpare(Ball first) {
        return (first.pin + this.pin) == 10;
    }

    public int getPin() {
        return pin;
    }
}
