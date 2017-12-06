import java.util.Scanner;

public class Input {
	
	private static Scanner sc = new Scanner(System.in);
	
	static String getName() {
		System.out.print("플레이어 이름은?(3 english letters) : ");
		return sc.nextLine();
	}
	
	static String getScore(int i) {
		System.out.print((i + 1) + " 프레임 투구 : ");
		return sc.nextLine();
	}
}
