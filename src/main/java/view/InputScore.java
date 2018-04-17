package view;

import java.util.Scanner;

public class InputScore {

	public static String bowlingGameStart(Scanner scan) {
		String name = inputPlayerName(scan);
		System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
		System.out.println("|  " + name + " |      |      |      |      |      |      |      |      |      |      |");
		System.out.println();
		return name;
	}

	public static String inputPlayerName(Scanner scan) {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		String name = scan.nextLine();

		if (name.length() > 3) {
			System.out.println("세글자로 입력해 듀오");
			return inputPlayerName(scan);
		}
		return name;
	}

	public static int inputScore(Scanner scan) {
//		System.out.print("" + frame + "프레임 투구 : ");
		int score = scan.nextInt();
		return score;
	}
}
