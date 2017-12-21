package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	public static int getNumOfPlayer(Scanner sc) {
		System.out.print("How many people?");
		return sc.nextInt();
	}

	public static List<String> getPlayers(int playerNum, Scanner sc) {
		List<String> playerNames = new ArrayList<>();
		for (int i = 1; i < playerNum + 1; i++) {
			System.out.print("플레이어 " + i + "의 이름은?(3 english letters):");
			playerNames.add(sc.next());
		}
		return playerNames;
	}

	public static int getFalledPin(Scanner sc) {
		return sc.nextInt();
	}
}
