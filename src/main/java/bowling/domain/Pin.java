package bowling.domain;

public class Pin {
    private static final int MAX_VALUE = 10;
    private static final int MIN_VALUE = 0;

    private int fellPin;

    public Pin(int fellPin) {
        checkInputValidation(fellPin);

        this.fellPin = fellPin;
    }

    private void checkInputValidation(int fellPin) {
        if(fellPin < MIN_VALUE || MAX_VALUE < fellPin)
            throw new IllegalArgumentException("Invalid input for pin");
    }
}
