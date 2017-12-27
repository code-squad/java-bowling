package bowling;

import java.util.Scanner;

public class InputView {

	public static String inputName() {
		System.out.println("플레이어 이름을 입력해 주세요 : ");
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public static int inputScore(int frameNum, Frame frame) throws InputException {
		while (true) {
			try {
				System.out.print("\n" + (frameNum) + " 프레임 투구 : ");
				Scanner sc = new Scanner(System.in);
				int score = sc.nextInt();
				if (isWrongScore(score)) {
					throw new InputException("0 ~ 10 사이의 정수만 입력 가능합니다.");
				}
				if (isSecondWrong(frame, score)) {
					throw new InputException("총 핀의 갯수는 10입니다. 이를 넘을 수 없습니다.");
				}
				return score;
			}
			catch (InputException inputException) {
			}
		}
	}
	
	private static boolean isSecondWrong(Frame frame, int score) {
		System.out.println(frame.checkSecondIsRight());
		return frame.checkSecondIsRight() + score > 10;
	}
	private static boolean isWrongScore(int score) {
		return score < 0 || score > 10;
	}
}