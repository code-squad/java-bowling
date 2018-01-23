package bowling.domain;

import bowling.common.StaticVariables;

import java.util.Optional;

public class Pin {
    private int fellPin;

    public Pin(int fellPin) {
        checkInputValidation(fellPin);

        this.fellPin = fellPin;
    }

    private void checkInputValidation(int fellPin) {
        if(fellPin < StaticVariables.MIN_VALUE || StaticVariables.MAX_VALUE < fellPin)
            throw new IllegalArgumentException("Invalid input for pin");
    }

    public int getNumOfFellPin() {
        return fellPin;
    }

    private String toSymbol(int fellPin) {
        return fellPin == 0 ? StaticVariables.GUTTER : StaticVariables.STRIKE;
    }

    public boolean isOverTen(Pin pin) {
        return fellPin + pin.fellPin > StaticVariables.MAX_VALUE;
    }

    public boolean isStrike() {
        return fellPin == StaticVariables.MAX_VALUE;
    }

    public boolean isSpare(Pin secondTry) {
        return Optional.ofNullable(secondTry)
                .map(second -> second.fellPin + this.fellPin == StaticVariables.MAX_VALUE)
                .orElse(false);
    }

    @Override
    public String toString() {
        if(fellPin == 0 || fellPin == 10)
            return toSymbol(fellPin);

        return String.valueOf(fellPin);
    }
}
