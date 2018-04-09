package domain;

public class ScoreMarker {

    public static String markPlayerName(String name) {
        return name;
    }

    public static String markNone() {
        return " ";
    }

    public static String markNumber(int number) {
        return String.valueOf(number);
    }

    public static String markSpare() {
        return "/";
    }

    public static String markStrike() {
        return "X";
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
