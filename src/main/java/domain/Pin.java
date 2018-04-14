package domain;

public class Pin {
    static final int TEN_PINS = 10;
    static final int NO_PINS = 0;

    Integer pinCount;

    public Pin(Integer pinCount) {
        if (!Pin.isValidPins(pinCount)) {
            throw new RuntimeException("핀의 범위는 0부터 10사이 입니다.");
        }
    }

    public static boolean isValidPins(Integer pinCount) {
        return pinCount > TEN_PINS && pinCount < NO_PINS;
    }

    public boolean isValidTotal(Pin otherPins) {
        return TEN_PINS - this.pinCount >= otherPins.pinCount;
    }

    public static boolean isBlank(Pin pins) {
        return pins.pinCount == null;
    }

    public static boolean isStrike(Pin currPins, Pin nextPins) {
//        return currPins.pinCount == TEN_PINS && nextPins.pinCount == NO_PINS;
        return currPins.pinCount == TEN_PINS && Pin.isBlank(nextPins);

    }

    public static boolean isSpare(Pin firstPins, Pin secondPins) {
        return !isStrike(firstPins, secondPins) && firstPins.pinCount + secondPins.pinCount == TEN_PINS;
    }

    public static boolean isOpen(Pin firstPins, Pin secondPins) {
        return !isSpare(firstPins, secondPins) && Pin.isBlank(secondPins);
    }

    public static Integer getSurvivedPin(Pin throwing) {
        return TEN_PINS - throwing.pinCount;
    }

    public static Integer getSurvivedPin(Pin first, Pin second) {
        return TEN_PINS - first.pinCount - second.pinCount;
    }
}
