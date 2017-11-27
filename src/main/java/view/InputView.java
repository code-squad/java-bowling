package view;

import java.util.Scanner;

public class InputView {
	public static String getPlayerName(Scanner sc) {
		System.out.print("플레이어 이름은(3 english letters)?:");
		return sc.next();
	}

	public static int getFalledPin(Scanner sc) {
		return sc.nextInt();
	}

}
