package bowling.view;

import java.util.Scanner;

public class BowlingFormView {
	static private Scanner scanner = new Scanner(System.in);

	public static String name() {
		System.out.print(" 이름을 입력하세요 : ");
		return scanner.nextLine();
	}

	public static int score(String name) {
		System.out.print(name + " 점수 입력하세요 : ");
		return Integer.parseInt(scanner.nextLine());
	}

}
