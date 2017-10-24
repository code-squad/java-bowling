package bowling.view;

import java.util.Scanner;

public class BowlingFormView {

	public static String inputName(Scanner scanner) {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		return scanner.nextLine();
	}

	public static int inputScore(String name, Scanner scanner) {
		System.out.print(name + "'turn : ");
		return Integer.parseInt(scanner.nextLine());
	}

}
