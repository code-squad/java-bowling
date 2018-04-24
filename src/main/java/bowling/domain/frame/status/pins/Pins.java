package bowling.domain.frame.status.pins;

import static bowling.domain.frame.status.Status.ALL;
import static bowling.domain.frame.status.Status.NONE;

public class Pins {
    private final int pins;

    private Pins(int prevPins, int currPins) {
        validatePinsKnocked(prevPins, currPins);
        this.pins = currPins;
    }

    private static void validatePinsKnocked(int prevKnockedPins, int currKnockedPins) throws IllegalArgumentException {
        if (currKnockedPins > ALL) {
            throw new IllegalArgumentException("핀의 개수가 10보다 큽니다.");
        }
        if (currKnockedPins < NONE) {
            throw new IllegalArgumentException("핀의 개수가 0보다 작습니다");
        }
        if (currKnockedPins > ALL - prevKnockedPins) {
            throw new IllegalArgumentException("남은 핀의 개수보다 많습니다.");
        }
    }

    public static Pins ofFirstBowl(int pins) {
        return new Pins(NONE, pins);
    }

    public static Pins ofSecondBowl(int prevKnockedPins, int currKnockedPins) {
        return new Pins(prevKnockedPins, currKnockedPins);
    }

    public int getPins() {
        return pins;
    }

    @Override
    public String toString() {
        return pins + "";
    }
}