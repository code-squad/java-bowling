import java.util.Scanner;

public class Input {
	
	private static Scanner sc = new Scanner(System.in);
	
	static String getName() {
		System.out.print("플레이어 이름은?(3 english letters) : ");
		String name = sc.nextLine();
		return name;
	}
	
	static int getPinsPerTry(Player player) {
		int frameNum = player.getFrameNum();
		System.out.print((frameNum + 1) + " 프레임 투구 : ");
		return Integer.parseInt(sc.nextLine());
	}
}