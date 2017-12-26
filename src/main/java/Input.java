
import java.util.Scanner;

public class Input {
	
	private static Scanner sc = new Scanner(System.in);
	
	static int getHowManyPeople() {
		System.out.print("How many people? : ");
		int howMany = Integer.parseInt(sc.nextLine());
		return howMany;
	}
	
	static String getName() throws InputException{
		System.out.print("플레이어 이름은?(3 english letters) : ");
		String name = sc.nextLine();
		if (name.length() != 3) {
			throw new InputException("3글자로 입력해주세요");
		}
		if (InputException.isString(name)) {
			throw new InputException("알파벳으로 입력해주세요");
		}
		return name;
	}
	
	static int getPinsPerTry(Player player) throws InputException{
		System.out.print((player.getCurrentFrameNo() + 1) + " 프레임 투구 : ");
		int pinsPerTry = Integer.parseInt(sc.nextLine());
		if (pinsPerTry < 0 || pinsPerTry > 10) {
			throw new InputException("0 ~ 10 숫자만 입력해주세요");
		}
		return pinsPerTry;
	}
}