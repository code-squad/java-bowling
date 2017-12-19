package bowling;

import java.util.Scanner;

public class InputView {

	public static int inputScore(int frameNum) {
		System.out.print("\n" + frameNum + " 프레임 투구 : ");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		sc.reset();
		return score;
	}
}