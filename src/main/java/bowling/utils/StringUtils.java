package bowling.utils;

public class StringUtils {
    public static final String BEGIN_FORMAT = "|  %s  |";
    public static final String BEGIN_NAME_FORMAT = "| %s  |";
    public static final String DEFAULT_ING_FORMAT = "  %s  |";
    public static final String SHORT_ING_FORMAT = "%s |";
    public static final String ONLY_ING_FORMAT = "  %s";
    public static final String RESULT_SCORE_FORMAT = "%s|%s";
    public static final String SCORE_INPUT_FORMAT = "%d프레임 투구 : ";
    public static final String EMPTY_FRAME = "  ";
    public static final String EMPTY_BLOCK_FRAME = "   |";

    public static String scoreResultFormat(String firstScore, String secondScore) {
        return String.format(RESULT_SCORE_FORMAT, firstScore, secondScore);
    }

    public static String getIngFormat(String result) {
        return String.format(SHORT_ING_FORMAT, result);
    }

    public static String getIngOnlyFormat(String result) {
        return String.format(ONLY_ING_FORMAT, result);
    }

    public static String emptyBlockFormat(String result) {
        return String.format("%s   |", result);
    }
}
