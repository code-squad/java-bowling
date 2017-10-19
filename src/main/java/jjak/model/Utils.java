package jjak.model;
import java.util.Scanner;

public class Utils {
	public static String insertName() {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		scanner.close();
		return name;
	}

	public static int insertScore() {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		scanner.close();
		return score;
	}
}
