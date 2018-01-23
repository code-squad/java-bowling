package bowling.view;

import java.util.stream.IntStream;

import static bowling.utils.BowlingUtils.BEGIN_FORMAT;
import static bowling.utils.BowlingUtils.ING_FORMAT;
import static bowling.utils.BowlingUtils.MAX_SCORE;
import static bowling.utils.BowlingUtils.MIN_POSSIBLE_SCORE;

public class Output {

    public static void print(String value) {
        System.out.println(value);
    }

    public static String topLine() {
        StringBuilder builder = new StringBuilder(String.format(BEGIN_FORMAT, "NAME"));
        IntStream.range(MIN_POSSIBLE_SCORE, MAX_SCORE).forEach(i -> builder.append(String.format(ING_FORMAT, "0"+i)));
        builder.append(String.format(ING_FORMAT, MAX_SCORE));

        return builder.toString();
    }
}
