package view;

import java.util.Scanner;

public class ConsoleInputView {

    public static String getPlayerName(Scanner sc) {
        System.out.print("플레이  어 이름은(3 english letters)?:");
        return sc.nextLine();
    }

    public static int enterScore(Scanner scan, int frameNo) {
        System.out.print("" + frameNo + "프레임 투구 : ");
        return Integer.parseInt(scan.nextLine());
    }
}
