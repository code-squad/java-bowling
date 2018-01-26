package bowling.domain;

import java.util.Optional;

import static bowling.common.StaticVariables.*;

public class Pin {
    private int fellPin;

    public Pin(int fellPin) {
        checkInputValidation(fellPin);

        this.fellPin = fellPin;
    }

    public int toIntValue() {
        return fellPin;
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

    public boolean isMiss(Pin secondTry) {
        return Optional.ofNullable(secondTry)
                .isPresent();
    }

    private void checkInputValidation(int fellPin) {
        if(fellPin < MIN_VALUE || MAX_VALUE < fellPin)
            throw new IllegalArgumentException("Invalid input for pin");
    }

    public Integer add(Pin secondTry) {
        return Optional.ofNullable(secondTry)
                .map(s -> s.fellPin + fellPin)
                .orElse(null);
    }

    public Integer calculateSpare() {
        return this.fellPin + 10;
    }
}
