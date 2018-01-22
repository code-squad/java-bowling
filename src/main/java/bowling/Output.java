package bowling;

import java.util.stream.IntStream;

import static bowling.BowlingUtils.MAX_SCORE;
import static bowling.BowlingUtils.MIN_SCORE;

public class Output {
    private static final String BEGIN_FORMAT = "| NAME |";
    private static final String ING_FORMAT = " %s |";

    public static void print(String value) {
        System.out.println(value);
    }

    public static String topLine() {
        StringBuilder builder = new StringBuilder(BEGIN_FORMAT);
        IntStream.rangeClosed(MIN_SCORE, MAX_SCORE-1).forEach(i -> builder.append(String.format(ING_FORMAT, "0"+i)));
        builder.append(String.format(ING_FORMAT, MAX_SCORE));

        return builder.toString();
    }
}
