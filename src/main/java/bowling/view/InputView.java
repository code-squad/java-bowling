package bowling.view;

import java.util.Scanner;

public class InputView {

    public static String inputPlayerName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("플레이어 이름은(3 english letters)?: ");
        return scanner.next();
    }

    public static int inputShot(int turn) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(String.valueOf(turn) + "프레임 투구 : ");
        return scanner.nextInt();
    }
}
