package view;

import domain.frame.Frame;

import java.util.List;
import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	
	public static String showGetPlayerNameView() {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		return scanner.nextLine();
	}

	public static int showGetPinCountView(int nextFrameNumber) {
		System.out.print(nextFrameNumber + "프레임 투구 : ");
		return Integer.parseInt(scanner.nextLine());
	}
}
