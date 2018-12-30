package bowling.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String PLAYER_COUNT = "플레이어는 몇명인가? : ";
    private static final String PLAYER = "플레이어 이름은(3 english letters)? : ";
    private static final String BOWL_FRAME = "%3s 님의 %2s프레임 투구 : ";

    private InputView() {}

    public static int initPlayerCount() {
        System.out.print(PLAYER_COUNT);
        return Integer.valueOf(scanner.nextLine());
    }

    public static String initPlayer() {
        System.out.print(PLAYER);
        return scanner.nextLine();
    }

    public static int initBowlFrame(String player, int frame) {
        System.out.print(String.format(BOWL_FRAME, player, frame));
        return Integer.valueOf(scanner.nextLine());
    }
}
