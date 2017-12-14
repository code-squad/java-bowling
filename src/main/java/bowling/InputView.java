package bowling;

import java.util.Scanner;

public class InputView {
	//player 이름을 입력 받는다.
	public static String getName() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("플레이어 이름 : ");
		String name = scan.nextLine();
		
		return name;
	}
}
