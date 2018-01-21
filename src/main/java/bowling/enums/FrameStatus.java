package bowling.enums;

public enum FrameStatus {
    NOT_START,
    STRIKE,
    SPARE,
    MISS,
    NOT_END;

    public static FrameStatus valueOf(int firstTry, int secondTry) {
        if(firstTry < 0)
            return NOT_START;
        if(firstTry == 10)
            return STRIKE;
        if(secondTry < 0)
            return NOT_END;
        if(firstTry + secondTry == 10)
            return SPARE;

        return MISS;
    }
}
