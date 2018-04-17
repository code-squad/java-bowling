package bowling.view;

import java.util.Scanner;

/**
 * @author sangsik.kim
 */
public class InputView {
    private static final String INPUT_PLAYER_NAME_TEXT = "플레이어 이름은(3 english letters)? : ";
    private static final String INPUT_HIT_COUNT_TEXT = "%d프레임 투구 : ";
    private static final String SCORE_BOARD_TITLE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getPlayerName() {
        System.out.println(INPUT_PLAYER_NAME_TEXT);
        return scanner.next();
    }

    public static int getDownPins(int hitCount) {
        System.out.printf(INPUT_HIT_COUNT_TEXT, hitCount);
        return scanner.nextInt();
    }

    public static void printScore(){
        System.out.println(SCORE_BOARD_TITLE);
    }
}
