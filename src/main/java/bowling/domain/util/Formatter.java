package bowling.domain.util;

public class Formatter {

    public static String formatFrame(String frame) {
        String leftPadded = String.format("%4s", frame);
        return String.format("%-6s", leftPadded);
    }
}