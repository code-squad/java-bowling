package bowling.view;

import java.util.Scanner;

public class InputView {
	static Scanner scanner = new Scanner(System.in);

	public static String askPlayer() {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		return scanner.nextLine();
	}

	public static int askScore(int id) {
		System.out.print(String.format("%d프레임 투구: ", id));
		return scanner.nextInt();
	}
}
