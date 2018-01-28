package bowling.utils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtils {
    public static final String BEGIN_FORMAT = "|  %s  |";
    public static final String BEGIN_NAME_FORMAT = "| %s  |";
    public static final String DEFAULT_ING_FORMAT = "  %s  |";
    public static final String RESULT_SCORE_FORMAT = "%s|%s";
    public static final String SCORE_INPUT_FORMAT = "%d프레임 투구 : ";
    public static final String EMPTY_FRAME = "  ";
    public static final String BLOCK_FRAME = "|";

    public static String scoreResultFormat(String firstScore, String secondScore) {
        return String.format(RESULT_SCORE_FORMAT, firstScore, secondScore);
    }

    public static String emptyBlockFormat(String result) {
        int length = 4 - result.length();
        return EMPTY_FRAME + result + IntStream.range(0, length).mapToObj(i -> " ").collect(Collectors.joining()) + BLOCK_FRAME;
    }
}
