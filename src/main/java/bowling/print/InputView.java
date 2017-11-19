package bowling.print;

import java.util.Scanner;

public class InputView {

	Scanner sc = null;
	
	public InputView(Scanner sc) {
		this.sc = sc;
	}
	
	public void endConsole() {
		sc.close();
	}
	
	public String getName() {
		System.out.print("플레이어 이름은?(3 english letters)?");
		return sc.next();
	}
	
	public int getThrowedPin(int frameNum) {
		System.out.printf("\n%1d프레임 투구 : ", frameNum);
		return sc.nextInt();
	}
}
