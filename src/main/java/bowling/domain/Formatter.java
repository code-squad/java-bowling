package bowling.domain;

public class Formatter {
    public static final int FRAME_LENGTH = 6;

    public static String formatFrame(String frame) {
        int diff = FRAME_LENGTH - frame.length();
        return String.format("%-6s", frame);
    }


    public static String formatLabel(int frameNumber) {
        if (frameNumber < 10) {
            return "0" + frameNumber;
        }
        return String.valueOf(frameNumber);
    }
}