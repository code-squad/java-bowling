package bowling;

import java.util.Scanner;

public class InputView {
	
	public static String inputName() {
		System.out.println("플레이어 이름을 입력해 주세요 : ");
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public static int inputScore(int frameNum) {
		System.out.print("\n" + frameNum + " 프레임 투구 : ");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		sc.reset();
		return score;
	}
}