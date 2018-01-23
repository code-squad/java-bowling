package bowling.util;

import bowling.domain.Pin;

import java.util.Optional;

import static bowling.enums.FrameStatus.STRIKE;

public class PinUtil {

    public static int getNumOfPin(Pin pin) {
        return Optional.ofNullable(pin)
                .map(Pin::getNumOfFellPin)
                .orElse(-1);
    }

    public static String toView(Pin pin) {
        return Optional.ofNullable(pin)
                .map(Pin::toString)
                .orElse(" ");
    }

    public static String toView(Pin firstTry, Pin secondTry) {
        return Optional.ofNullable(firstTry)
                .filter(first -> first.isSpare(secondTry))
                .map(fellPin -> "/")
                .orElse(toView(secondTry));
    }

    public static String toSplitor(Pin pin) {
        return Optional.ofNullable(pin)
                .filter(fellpin -> !fellpin.toString().equals(STRIKE))
                .map(fellPin -> "|")
                .orElse(" ");
    }
}
