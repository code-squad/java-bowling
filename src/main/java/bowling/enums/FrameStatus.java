package bowling.enums;

import bowling.domain.Pin;

public enum FrameStatus {
    NOT_START,
    STRIKE,
    SPARE,
    MISS,
    NOT_END;

    public static FrameStatus getStatus(Pin firstTry, Pin secondTry) {
        int numberOfFellPinOfFirstTry = Pin.getNumOfPin(firstTry);
        int numberOfFellPinOfSecondTry = Pin.getNumOfPin(secondTry);

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

    public static String toView(Pin firstTry, Pin secondTry) {
        switch(getStatus(firstTry, secondTry)) {
            case STRIKE:
                return "X  ";
            case SPARE:
                return firstTry.toString() + "|/";
            case MISS:
                return firstTry.toString() + "|" + secondTry.toString();
            case NOT_END:
                return firstTry.toString() + "  ";
        }
        return "   ";
    }

    public static boolean isEnd(FrameStatus status) {
        return status == STRIKE
                || status == SPARE
                || status == MISS;
    }

}
