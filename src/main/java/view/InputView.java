package view;

import java.util.Scanner;

import dto.InputValue;

public class InputView {
	private static Scanner sc = new Scanner(System.in);
	public static InputValue getUserId() {
		System.out.print("플레이어 이름은(3 english letters)?:");
		InputValue iv = new InputValue();
		iv.setUsrId(sc.next());
		return iv;
	}
	public static InputValue getFalledPin(int frameNum) {
		System.out.print(frameNum + "프레임 투구 :");
		InputValue iv = new InputValue();
		iv.setFalledPin(sc.nextInt());	
		return iv;
	}
}
