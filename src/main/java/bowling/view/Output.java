package bowling.view;

import java.util.stream.IntStream;

import static bowling.utils.StringUtils.BEGIN_NAME_FORMAT;
import static bowling.utils.StringUtils.DEFAULT_ING_FORMAT;
import static bowling.utils.ScoreUtils.MAX_SCORE;
import static bowling.utils.ScoreUtils.MIN_POSSIBLE_SCORE;

public class Output {

    public static void print(String value) {
        System.out.print(value);
    }

    public static void printLine(String value) {
        System.out.println(value);
    }

    public static String topLine() {
        StringBuilder builder = new StringBuilder(String.format(BEGIN_NAME_FORMAT, "NAME"));
        IntStream.range(MIN_POSSIBLE_SCORE, MAX_SCORE).forEach(i -> builder.append(String.format(DEFAULT_ING_FORMAT, "0"+i)));
        builder.append(String.format(DEFAULT_ING_FORMAT, MAX_SCORE));

        return builder.toString();
    }
}
