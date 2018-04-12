package bowling.domain.Utils;

public class Formatter {
    private static final int LAST_FRAME = 10;

    public static String formatFrame(String frame) {
        return String.format("%-6s", frame);
    }

    public static String formatLabel(int frameNumber) {
        if (frameNumber < LAST_FRAME) {
            return "0" + frameNumber;
        }
        return String.valueOf(frameNumber);
    }

    public static int convertToInt(String number) throws IllegalArgumentException {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }
}