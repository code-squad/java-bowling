package bowling.domain;

public class Ball {

    static final int MAX_PIN = 10;
    static final int MIN_PIN = 0;

    private int pin;

    private Ball(int pin) {
        if (pin < MIN_PIN || MAX_PIN < pin) {
            throw new IllegalArgumentException("핀의 개수를 정확히 입력해주세요");
        }
        this.pin = pin;
    }

    public static Ball of(int pin) {
        return new Ball(pin);
    }

    public boolean isTenPin() {
        return pin == 10;
    }

    public boolean isSpare(Ball second) {
        return (pin + second.getPin()) == 10;
    }

    public int getPin() {
        return pin;
    }
}
