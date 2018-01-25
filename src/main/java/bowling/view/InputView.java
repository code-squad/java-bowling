package bowling.view;

import bowling.domain.DownPinCount;
import bowling.domain.Player;

import java.util.Scanner;

public class InputView {
    private static final String THROW_PROMPT= "%d프레임 투구: ";
    private static final String INPUT_PLAYER_PROMPT= "플레이어 이름은(3 english letters)?: ";
    private static final Scanner scanner = new Scanner(System.in);


    public static Player inputPlayer() {
        System.out.print(INPUT_PLAYER_PROMPT);
        return Player.of(scanner.nextLine());
    }

    public static DownPinCount inputThrow(int frameNo) {
        System.out.print(String.format(THROW_PROMPT, frameNo));
        return DownPinCount.of(scanner.nextLine());
    }
}
