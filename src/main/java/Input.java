import java.util.Scanner;

public class Input {
	
	private static Scanner sc = new Scanner(System.in);
	
	static String getName() {
		System.out.print("플레이어 이름은?(3 english letters) : ");
		return sc.nextLine();
	}
	
	static int getPinsPerTry() {
		System.out.print(" 프레임 투구 : ");
		return Integer.parseInt(sc.nextLine());
	}
}
