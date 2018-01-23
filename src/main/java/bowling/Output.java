package bowling;

import java.util.stream.IntStream;

import static bowling.BowlingUtils.BEGIN_FORMAT;
import static bowling.BowlingUtils.ING_FORMAT;
import static bowling.BowlingUtils.MAX_SCORE;
import static bowling.BowlingUtils.MIN_SCORE;

public class Output {

    public static void print(String value) {
        System.out.println(value);
    }

    public static String topLine() {
        StringBuilder builder = new StringBuilder(String.format(BEGIN_FORMAT, "NAME"));
        IntStream.rangeClosed(MIN_SCORE, MAX_SCORE-1).forEach(i -> builder.append(String.format(ING_FORMAT, "0"+i)));
        builder.append(String.format(ING_FORMAT, MAX_SCORE));

        return builder.toString();
    }
}
