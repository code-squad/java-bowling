package bowling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

	public static int inputScore(int frameNum) throws Exception {
		System.out.print("\n" + frameNum + " 프레임 투구 : ");
		Scanner sc = new Scanner(System.in);
		int score = 0;

		try {
			score = sc.nextInt();
			validateScopeOfScore(score);
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력할 수 있습니다.");
			return inputScore(frameNum);
		}
		 catch (MyException e) {
			System.out.println(e.getErrorMessage());
			return inputScore(frameNum);
		}

		sc.reset();
		return score;
	}
	
	public static String inputName(){
		System.out.print("플레이어 이름은? (3 english letter) : ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private static void validateScopeOfScore(int score) throws MyException {
		if (score > 10 || score < 0) 
			throw new MyException("숫자의 범위를 넘으셨습니다.");
	}
}
