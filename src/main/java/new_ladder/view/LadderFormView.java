package new_ladder.view;

import java.util.Scanner;

public class LadderFormView {
	private static Scanner scanner = new Scanner(System.in);

	public static String playersInput() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) : ");
		return scanner.nextLine();
	}

	public static int ladderHeight() {
		System.out.println("최대 사다리 높이는 몇 개인가요? : ");
		return Integer.parseInt(scanner.nextLine());
	}

}
