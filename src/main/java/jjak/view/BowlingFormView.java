package jjak.view;

import java.util.Scanner;

public class BowlingFormView {

	public static int insertPlayerCount(Scanner scanner) {
		System.out.println("인원을 입력하세요 : ");
		int playerCount = Integer.parseInt(scanner.nextLine());
		return playerCount;
	}

	public static String insertName(Scanner scanner) {
		System.out.println("이름을 입력하세요 : ");
		String name = scanner.nextLine();
		return name;
	}

	public static int insertScore(Scanner scanner) {
		System.out.println("점수를 입력하세요 : ");
		int score = Integer.parseInt(scanner.nextLine());
		return score;
	}

}
