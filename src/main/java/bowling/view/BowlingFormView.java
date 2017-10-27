package bowling.view;

import java.util.Scanner;

import bowling.exception.BowlingException;

public class BowlingFormView {
	static Scanner scanner = new Scanner(System.in);

	public static String inputName() {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		return scanner.nextLine();
	}

	public static int inputScore(String name) throws BowlingException {
		int score = 0;
		try {
			System.out.print(name + "'turn : ");
			score = Integer.parseInt(scanner.nextLine());
		} catch (BowlingException e) {
			e.printStackTrace();
		}
		return score;
	}

}
