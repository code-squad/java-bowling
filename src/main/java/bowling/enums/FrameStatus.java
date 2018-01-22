package bowling.enums;

import bowling.domain.Pin;

import java.util.Optional;

public enum FrameStatus {
    NOT_START,
    STRIKE,
    SPARE,
    MISS,
    NOT_END;

    public static FrameStatus getStatus(Pin firstTry, Pin secondTry) {
        int numberOfFellPinOfFirstTry = Optional.ofNullable(firstTry)
                .map(Pin::getNumOfFellPin)
                .orElse(-1);

        int numberOfFellPinOfSecondTry = Optional.ofNullable(secondTry)
                .map(Pin::getNumOfFellPin)
                .orElse(-1);

        if(numberOfFellPinOfFirstTry < 0)
            return NOT_START;
        if(numberOfFellPinOfFirstTry == 10)
            return STRIKE;
        if(numberOfFellPinOfSecondTry < 0)
            return NOT_END;
        if(numberOfFellPinOfFirstTry + numberOfFellPinOfSecondTry == 10)
            return SPARE;

        return MISS;
    }
}
