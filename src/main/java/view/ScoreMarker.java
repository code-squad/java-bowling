package view;

public class ScoreMarker {

    public static String markStrike() {
        return "X| ";
    }

    public static String markSpare(int firstThrow) {
        return firstThrow + "|/";
    }

    public static String markNumber(Integer firstThrow, Integer secondThrow) {
        String first, second;

        return
    }

    private static String convertToAppropriateMark(Integer number) {
        if (number == null) {
            return " ";
        }
        if (number == STRIKE) {
            return "X";
        }
        if (number == SPARE) {
            return "/";
        }
        return String.valueOf(number);
    }


    public static String markBonusNumber(int number) {
        return "|" + number;
    }

    public static String markEmpty() {
        return " ";
    }

    public static String markNone() {
        return "-";
    }

    public static String markSeparator() {
        return "|";
    }

    public static String markFrameNumber(int frameNumber) {
        String number = String.valueOf(frameNumber);
        if (number.length() == 1) {
            return "0" + number;
        }
        return number;
    }
}
