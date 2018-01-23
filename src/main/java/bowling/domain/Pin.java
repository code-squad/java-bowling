package bowling.domain;

import java.util.Optional;

public class Pin {
    private static final int MAX_VALUE = 10;
    private static final int MIN_VALUE = 0;
    private static final String GUTTER = "-";
    private static final String STRIKE = "X";

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

    private String toSymbol(int fellPin) {
        return fellPin == 0 ? GUTTER : STRIKE;
    }

    public boolean isOverTen(Pin pin) {
        return fellPin + pin.fellPin > MAX_VALUE;
    }

    public boolean isStrike() {
        return fellPin == MAX_VALUE;
    }

    public boolean isSpare(Pin secondTry) {
        return Optional.ofNullable(secondTry)
                .map(second -> second.fellPin + this.fellPin == MAX_VALUE)
                .orElse(false);
    }

    @Override
    public String toString() {
        if(fellPin == 0 || fellPin == 10)
            return toSymbol(fellPin);

        return String.valueOf(fellPin);
    }
}
