package view;

import domain.frame.Frame;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	
	public static String showGetPlayerNameView() {
		System.out.print("플레이어 이름은(3 english letters)?: ");
		return scanner.nextLine();
	}
	
	public static Frame showGetFrameResultView(int frameNumber, Frame lastFrame) {
		System.out.print((frameNumber + 1) + "프레임 투구 : ");
		return lastFrame.bowl(Integer.parseInt(scanner.nextLine()));
	}
}
