package bowling.enums;

import bowling.domain.Pin;

import java.util.Optional;

public enum FrameState {
    STRIKE,
    SPARE,
    MISS,
    NOT_END;

    public static FrameState getStatus(Pin firstTry, Pin secondTry) {
        if(firstTry == null)
            return NOT_END;

        if(firstTry.isStrike())
            return STRIKE;

        if(firstTry.isSpare(secondTry))
            return SPARE;

        if(firstTry.isMiss(secondTry))
            return MISS;

        return NOT_END;
    }

    public boolean isEnd() {
        return this == STRIKE || this == SPARE || this == MISS;
    }

    public static boolean isStrike(Pin firstTry) {
        return Optional.ofNullable(firstTry)
                .map(Pin::isStrike)
                .orElse(false);
    }

    public static boolean isSpare(Pin firstTry, Pin secondTry) {
        return Optional.ofNullable(firstTry)
                .map(pin -> pin.isSpare(secondTry))
                .orElse(false);
    }
}
