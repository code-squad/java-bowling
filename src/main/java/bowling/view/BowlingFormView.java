package bowling.view;

import java.util.Scanner;

public class BowlingFormView {
	public static int inputNumbers(Scanner scanner) {
		System.out.println("인원을 입력 해 주세요.");
		int numbers = Integer.parseInt(scanner.nextLine());
		return numbers;
	}
	
	public static String inputName(Scanner scanner) {
		System.out.println("이름을 입력 해 주세요.");
		String name = scanner.nextLine();
		return name;
	}
	
	public static int inputBowl(Scanner scanner) {
		System.out.println("당신의 턴 입니다.");
		int knockedPins = Integer.parseInt(scanner.nextLine());
		return knockedPins;
	}
}
