package bowling.util;

public class ScoreAssistance {
    public final static int MAX_PIN_COUNT = 10;

    public static boolean isOverMaxPinCount(Integer number) {
        if (number == null) return true;
        if (number > MAX_PIN_COUNT) return true;
        return false;
    }
}
