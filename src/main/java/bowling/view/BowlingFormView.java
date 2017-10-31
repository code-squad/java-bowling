package bowling.view;

import java.util.Scanner;

public class BowlingFormView {
	static Scanner scanner = new Scanner(System.in);

	public static int inputPlayerCount() {
		System.out.print("플레이어의 수를 입력하세요 :");
		return Integer.parseInt(scanner.nextLine());
	}

	public static String inputName() {
		System.out.print("플레이어의 이름을 입력하세요 :");
		return scanner.nextLine();
	}

	public static int inputScore(String name) {
		System.out.print(name + "'의 점수를 입력하세요 :");
		return Integer.parseInt(scanner.nextLine());
	}

}
