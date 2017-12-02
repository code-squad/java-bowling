package view;

import java.util.Scanner;

import Exception.InvalidFalledPinInputException;

public class InputView {
	public static int falledPin;
	private static Scanner sc = new Scanner(System.in);
	public static String getPlayerName(Scanner sc) {
		System.out.print("플레이어 이름은(3 english letters)?:");
		return sc.next();
	}

	public static void getFalledPin() throws InvalidFalledPinInputException {
		InputView.falledPin = sc.nextInt();
		if(InputView.falledPin >=0 && InputView.falledPin <= 10) {
			return;
		}
		else {
			throw new InvalidFalledPinInputException();
		}
	}
}
