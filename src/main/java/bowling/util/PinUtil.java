package bowling.util;

import bowling.domain.Pin;

import java.util.Optional;

import static bowling.common.StaticVariables.*;

public class PinUtil {

    public static String frameView(Pin firstTry, Pin secondTry) {
        return toView(firstTry) + toView(firstTry, secondTry);
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

    public static String toSymbol(int fellPin) {
        return fellPin == 0 ? GUTTER : STRIKE;
    }
}
