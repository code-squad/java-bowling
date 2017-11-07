package Ladder;

import java.util.Random;

import Ladder.view.LadderFormView;

public class LadderGame {
	public static void main(String[] args) {
		LadderGame ladderGame = new LadderGame();
		String[] names = LadderFormView.playersInput().split(",");
		int height = LadderFormView.ladderHeight();
		boolean[][] ladder = ladderGame.makeLadder(names, height);

		Random random = new Random();
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < names.length; i++) {
				int x = random.nextInt();
				ladder[i][j] = makeRoute(x);
			}
		}

		for (int j = 0; j < height; j++) {
			int check = 0;
			for (int i = 0; i < names.length; i++) {
				if (ladder[i][j] == true) {
					check++;
				}
				if (check == 2) {
					ladder[i][j] = false;
					check = 0;
				}
			}
		}

		for (int j = 0; j < height; j++) {
			for (int i = 0; i < names.length; i++) {
				System.out.print("|");
				if (i + 1 == names.length) {
					break;
				}
				if (ladder[i][j] == true) {
					System.out.print("-----");
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
			if (j + 1 == height) {
				printName(names);
			}
		}

		// Players players = Players.create(LadderFormView.playersInput());
		// Result result = new Result(players, LadderFormView.ladderHeight());
		// System.out.println(result.show().toString());
	}

	private static void printName(String[] names) {
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + "     ");
		}
	}

	private static boolean makeRoute(int x) {
		if (x % 2 == 0) {
			return true;
		}
		return false;
	}

	private boolean[][] makeLadder(String[] names, int ladderHeight) {
		boolean[][] ladder = new boolean[names.length][ladderHeight];
		return ladder;
	}
}
