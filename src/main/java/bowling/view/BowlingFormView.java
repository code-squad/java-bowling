package bowling.view;

import java.util.Scanner;

public class BowlingFormView {
	public static int getNumbers(Scanner scanner) {
		System.out.println("인원을 입력 해 주세요.");
		int number = Integer.parseInt(scanner.nextLine());
		return number;
	}
	
	public static String inputName(Scanner scanner) {
		System.out.println("이름을 입력 해 주세요.");
		String name = scanner.nextLine();
		return name;
	}
}
