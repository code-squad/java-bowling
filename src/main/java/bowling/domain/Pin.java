package bowling.domain;

import java.util.Optional;

public class Pin {
    private static final int MAX_VALUE = 10;
    private static final int MIN_VALUE = 0;
    private static final String GUTTER = "-";

    private int fellPin;

    public Pin(int fellPin) {
        checkInputValidation(fellPin);

        this.fellPin = fellPin;
    }

    private void checkInputValidation(int fellPin) {
        if(fellPin < MIN_VALUE || MAX_VALUE < fellPin)
            throw new IllegalArgumentException("Invalid input for pin");
    }

    public int getNumOfFellPin() {
        return fellPin;
    }

    public static int getNumOfPin(Pin pin) {
        return Optional.ofNullable(pin)
                .map(Pin::getNumOfFellPin)
                .orElse(-1);
    }

    public boolean isOverTen(Pin pin) {
        return fellPin + pin.fellPin > MAX_VALUE;
    }

    public boolean isStrike() {
        return fellPin == MAX_VALUE;
    }

    public boolean isSpare(Pin secondTry) {
        return fellPin + secondTry.fellPin == MAX_VALUE;
    }

    @Override
    public String toString() {
        return fellPin == 0 ? GUTTER : String.valueOf(fellPin);
    }
}
