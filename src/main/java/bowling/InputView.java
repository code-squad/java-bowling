package bowling;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

	public static int inputScore(Player player) throws Exception {
		System.out.print("\n" + player + " 투구 : ");
		Scanner sc = new Scanner(System.in);
		int score = 0;

		try {
			score = sc.nextInt();
			validateScopeOfScore(score);
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력할 수 있습니다.");
			return inputScore(player);
		}
		 catch (MyException e) {
			System.out.println(e.getErrorMessage());
			return inputScore(player);
		}

		sc.reset();
		return score;
	}
	public static int inputPlayerNum(){
		System.out.println("how many player? : ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	public static ArrayList<String> inputName(int playerNum){
		ArrayList<String> player = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < playerNum; i++) {
			System.out.print("플레이어" + i + "의 이름은? (3 english letter) : ");
			player.add(sc.next());
		}
		return player;
	}

	private static void validateScopeOfScore(int score) throws MyException {
		if (score > 10 || score < 0) 
			throw new MyException("숫자의 범위를 넘으셨습니다.");
	}

}
