package bowling.enums;

public enum FrameStatus {
    STRIKE,
    SPARE,
    MISS,
    NOT_END;

    public static FrameStatus valueOf(int firstTry, int secondTry) {
        int total = firstTry + secondTry;

        if(firstTry == 10)
            return STRIKE;
        if(secondTry < 0)
            return NOT_END;
        if(total == 10)
            return SPARE;

        return MISS;
    }
}
