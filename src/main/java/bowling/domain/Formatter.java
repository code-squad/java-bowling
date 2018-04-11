package bowling.domain;

public class Formatter {
    public static final int FRAME_LENGTH = 6;

    public static String formatFrame(String frame) {
        StringBuilder builder = new StringBuilder();
        int diff = FRAME_LENGTH - frame.length();
        return String.format("%-6s", frame);
    }
}
