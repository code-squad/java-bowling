package bowling.view;

import bowling.GameResult;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author sangsik.kim
 */
public class InputView {
    private static final String SCORE_FORMAT = "|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n";
    private static final String INPUT_PLAYER_NAME_TEXT = "플레이어 이름은(3 english letters)? : ";
    private static final String INPUT_KNOCK_DOWN_PIN_TEXT = "%d프레임 투구 : ";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getName() {
        System.out.print(INPUT_PLAYER_NAME_TEXT);
        return scanner.next();
    }

    public static int getPins(int frameNumber) {
        System.out.print(String.format(INPUT_KNOCK_DOWN_PIN_TEXT, frameNumber));
        return scanner.nextInt();
    }

    public static void displayFrameResult(GameResult gameResult) {
        System.out.println(getScoreHeader());
        System.out.println(getScore(gameResult));
    }

    private static String getScoreHeader() {
        return String.format(SCORE_FORMAT,
                StringUtils.center("NAME", 8),
                StringUtils.center("01", 9),
                StringUtils.center("02", 9),
                StringUtils.center("03", 9),
                StringUtils.center("04", 9),
                StringUtils.center("05", 9),
                StringUtils.center("06", 9),
                StringUtils.center("07", 9),
                StringUtils.center("08", 9),
                StringUtils.center("09", 9),
                StringUtils.center("10", 9));
    }

    private static String getScore(GameResult gameResult) {
        return String.format(SCORE_FORMAT, makeScoreFormat(gameResult));
    }

    private static Object[] makeScoreFormat(GameResult gameResult) {
        String[] result = new String[11];
        result[0] = StringUtils.center(gameResult.getPlayerName(), 8);
        for (int i = 1; i <= 10; i++) {
            result[i] = StringUtils.center(gameResult.getScore(i), 9);
        }
        return result;
    }
}
