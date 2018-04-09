package domain;

public class ScoreMarker {

    public static String markPlayerName(String name) {
        return name;
    }

    public static String markFrameNumber(int frameNumber) {
        String number = String.valueOf(frameNumber);
        if (number.length() == 1) {
            return "0" + number;
        }
        return number;
    }

    public static String markNumbers(int firstThrow, int secondThrow) {
        return firstThrow + "|" + secondThrow;
    }

    public static String markSpare(int firstThrow) {
        return firstThrow + "|/";
    }

    public static String markStrike() {
        return "X  ";
    }

    public static String markBonusNumber(int number) {
        return "|" + number;
    }

    public static String markEmpty() {
        return " ";
    }

    public static String markFrameSeparator() {
        return "|";
    }
}
