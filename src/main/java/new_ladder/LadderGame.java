package new_ladder;

import java.util.Random;

import new_ladder.view.LadderFormView;

public class LadderGame {
	public static void main(String[] args) {
		LadderGame ladderGame = new LadderGame();
		Random random = new Random();
		String[] names = LadderFormView.playersInput().split(",");
		int height = LadderFormView.ladderHeight();
		int userCount = names.length;
		boolean[][] ladder = ladderGame.initializeLadder(names, height);

		ladder = ladderGame.makeLadder(userCount, height, ladder, random);
		ladder = ladderGame.checkRoute(userCount, height, ladder);

		StringBuilder stringBuilder = ladderGame.print(names, height, ladder);
		System.out.println(stringBuilder.toString());
	}

	private boolean[][] initializeLadder(String[] names, int ladderHeight) {
		boolean[][] ladder = new boolean[names.length][ladderHeight];
		return ladder;
	}

	private boolean[][] makeLadder(int userCount, int height, boolean[][] ladder, Random random) {
		for (int j = 0; j < height; j++) {
			ladder = makeLow(userCount, ladder, random, j);
		}
		return ladder;
	}

	private boolean[][] makeLow(int userCount, boolean[][] ladder, Random random, int height) {
		for (int i = 0; i < userCount; i++) {
			int x = random.nextInt();
			ladder[i][height] = makeRoute(x);
		}
		return ladder;
	}

	private static boolean makeRoute(int x) {
		if (x % 2 == 0) {
			return true;
		}
		return false;
	}

	private boolean[][] checkRoute(int userCount, int height, boolean[][] ladder) {
		for (int j = 0; j < height; j++) {
			int check = 0;
			ladder = checkRow(userCount, ladder, j, check);
		}
		return ladder;
	}

	private boolean[][] checkRow(int userCount, boolean[][] ladder, int j, int check) {
		for (int i = 0; i < userCount; i++) {
			check = isContinuousRoute(ladder, j, check, i);
			check = brokenRoute(ladder, j, check, i);
		}
		return ladder;
	}

	private int isContinuousRoute(boolean[][] ladder, int j, int check, int i) {
		if (ladder[i][j] == true) {
			check++;
		}
		return check;
	}

	private int brokenRoute(boolean[][] ladder, int j, int check, int i) {
		if (check == 2) {
			ladder[i][j] = false;
			check = 0;
		}
		return check;
	}

	private StringBuilder print(String[] names, int height, boolean[][] ladder) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int j = 0; j < height; j++) {
			stringBuilder = printLadder(names, ladder, j, stringBuilder);
			stringBuilder = isLastLine(names, height, j, stringBuilder);
		}
		return stringBuilder;
	}

	private StringBuilder printLadder(String[] names, boolean[][] ladder, int j, StringBuilder stringBuilder) {
		int userCount = names.length;
		for (int i = 0; i < userCount; i++) {
			stringBuilder.append("|");
			stringBuilder.append(printRoute(ladder, j, i, userCount));
		}
		stringBuilder.append("\n");
		return stringBuilder;
	}

	private String printRoute(boolean[][] ladder, int j, int i, int userCount) {
		if (i + 1 == userCount) {
			return "";
		}
		if (ladder[i][j] == true) {
			return "=====";
		}
		return "     ";
	}

	private StringBuilder isLastLine(String[] names, int height, int j, StringBuilder stringBuilder) {
		if (j + 1 == height) {
			stringBuilder = printName(names, stringBuilder);
		}
		return stringBuilder;
	}

	private StringBuilder printName(String[] names, StringBuilder stringBuilder) {
		for (int i = 0; i < names.length; i++) {
			stringBuilder.append(names[i]);
			stringBuilder.append("     ");
		}
		return stringBuilder;
	}

}
