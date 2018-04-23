package bowling.domain.frame.status.pins;

import static bowling.domain.frame.status.Status.ALL;
import static bowling.domain.frame.status.Status.NONE;

public class Pins {
    private final int pins;

    private Pins(int prevPins, int currPins) {
        validatePinsKnocked(prevPins, currPins);
        this.pins = currPins;
    }

    private static void validatePinsKnocked(int prevPins, int currPins) throws IllegalArgumentException {
        if (currPins > ALL) {
            throw new IllegalArgumentException("핀의 개수가 10보다 큽니다.");
        }
        if (currPins < NONE) {
            throw new IllegalArgumentException("핀의 개수가 0보다 작습니다");
        }
        if (currPins > ALL - prevPins) {
            throw new IllegalArgumentException("남은 핀의 개수보다 많습니다.");
        }
    }

    public static Pins ofFirstBowl(int pins) {
        return new Pins(NONE, pins);
    }

    public static Pins ofSecondBowl(int pinsThatWereLeft, int pinsKnocked) {
        return new Pins(pinsThatWereLeft, pinsKnocked);
    }

    public int getPins() {
        return pins;
    }

    @Override
    public String toString() {
        return pins + "";
    }
}