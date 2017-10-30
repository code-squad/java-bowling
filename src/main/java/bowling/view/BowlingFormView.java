package bowling.view;

import java.util.Scanner;

public class BowlingFormView {
	static Scanner scanner = new Scanner(System.in);

	public static int inputPlayerCount() {
		System.out.print("플레이어의 수를 입력하세요 :");
		return Integer.parseInt(scanner.nextLine());
	}

}
