package bowling.view;

import java.util.Scanner;

import bowling.domain.User;
import bowling.domain.Users;

public class Input {

	public static Users makeUsers() {
		int userNum = inputUserNum();
		Users users = Users.of();
		for (int i = 0; i < userNum; i++) {
			users.addUser(User.of(inputName(i)));
		}
		return users;
	}

	public static int inputUserNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many people?");
		return sc.nextInt();
	}

	public static String inputName(int i) {
		Scanner sc = new Scanner(System.in);
		System.out.print("플레이어" + (i + 1) + "의 이름은(3 english letters)?: ");
		return sc.nextLine();
	}

	public static int inputThrowScore(String name, int frameNum) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(name + "'s turn :" + frameNum);
		return sc.nextInt();
	}

}
