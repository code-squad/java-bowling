package bowling.domain;

public class Pin {

    private static final int MAX = 10;
    private static final int MIN = 0;

    private int pin;

    private Pin() {}

    private Pin(int pin) {
        if (MAX < pin || MIN > pin)
            throw new IllegalPinException();

        this.pin = pin;
    }

    public static Pin of(int pin) {
        return new Pin(pin);
    }

    public Pin add(Pin pin) {
        return new Pin(this.pin + pin.pin);
    }

    public int getPin() {
        return this.pin;
    }

    public boolean isStrike() {
        return MAX == this.pin;
    }

    public boolean isSpare(Pin pin) {
        return MAX == this.pin + pin.pin;
    }

    public boolean isMiss(Pin pin) {
        return MAX > this.pin + pin.pin;
    }

    public boolean isGutter() {
        return MIN == this.pin;
    }

    private static class IllegalPinException extends RuntimeException {}
}
