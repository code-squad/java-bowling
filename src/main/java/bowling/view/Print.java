package bowling.view;

import bowling.domain.Game;
import bowling.domain.Pin;
import bowling.domain.User;
import bowling.domain.Users;

public class Print {

	private static final int MAX_RANGE = 10;

	public static void printFrame(Users users, int frameNum) {
		for (int i = 0; i < users.size(); i++) {
			printBaseUpBoard();
			System.out.print("|   " + users.getName(i) + "    ");
			printPinBoard(frameNum, users.getUser(i));
			printScoreBoard(frameNum, users.getUser(i));
		}
	}

	public static void printScoreBoard(int frameNum, User user) {
		printEmptyFrame();

		if (frameNum == 1) {
			printFirstScore(user.getOneBall());
			printEmptyScore(user.getGame());
			return;
		}

		for (int i = 0; i < user.size(); i++) {
			if (!user.canCalculateScore(i)) {
				printScore(user.getTotalScore(i));
			}
		}
		printNowScore(user.getOneBall(), user.getGame());
		printEmptyScore(user.getGame());
	}

	public static void printEmptyScore(Game game) {
		for (int i = game.size(); i < MAX_RANGE - 1; i++) {
			printEmptyFrame();
		}
		System.out.println("|");
	}

	public static void printNowScore(Pin pin, Game game) {
		if (pin.size() == 2 && !pin.isSpare()) {
			printScore(pin.beforePlusNow(game.getLastScore()));
		}
		if (pin.size() == 3) {
			printScore(pin.beforePlusNow(game.getLastScore()));
		}
	}

	public static void printFirstScore(Pin pin) {
		if (pin.size() == 2 && !pin.isSpare()) {
			printScore(pin.totalScore());
		}
	}

	public static void printPinBoard(int frameNum, User user) {
		if (frameNum == 1) {
			printFirstFrame(user);
			return;
		}
		if (frameNum == Game.LAST_FRAME) {
			printLastFrame(frameNum, user);
			return;
		}
		printNormalFrame(frameNum, user);
	}

	public static void printFirstFrame(User user) {
		printPin(user.getOneBall());
		for (int i = 2; i <= MAX_RANGE; i++) {
			printEmptyFrame();
		}
		System.out.print("|\n");
	}

	public static void printNormalFrame(int frameNum, User user) {
		printBeforeFrame(user.getGame());
		printPin(user.getOneBall());
		for (int i = 0; i < MAX_RANGE - frameNum; i++) {
			printEmptyFrame();
		}
		System.out.print("|\n");
	}

	public static void printLastFrame(int frameNum, User user) {
		printBeforeFrame(user.getGame());
		System.out.print("|   " + user.getOneBall().checkPin() + "    ");
		System.out.print("|\n");
	}

	public static void printBeforeFrame(Game game) {
		for (int j = 0; j < game.size(); j++) {
			System.out.print("|   ");
			System.out.print(game.getDownPin(j));
			System.out.print("    ");
		}
	}

	public static void printPin(Pin pin) {
		if (pin.size() == 0 || pin == null) {
			printEmptyFrame();
			return;
		}
		System.out.print("|   " + pin.checkPin() + "    ");
	}

	public static void printScore(int score) {
		if (score > 9) {
			System.out.print("|   " + score + "     ");
			return;
		}
		System.out.print("|   " + score + "      ");
	}

	public static void printEmptyFrame() {
		System.out.print("|    " + "  " + "    ");
	}

	public static void printBaseUpBoard() {
		System.out.print("|   Name   ");
		for (int i = 1; i < MAX_RANGE; i++) {
			System.out.print("|    " + "0" + i + "    ");
		}
		System.out.print("|   " + Game.LAST_FRAME + "     ");
		System.out.print("|\n");
	}

	public static void printBasePinBoard(String name) {
		System.out.print("|   " + name + "    ");
		for (int i = 1; i < MAX_RANGE; i++) {
			printEmptyFrame();
		}
		System.out.print("|          ");
		System.out.print("|\n");
	}

	public static void printBaseScoreBoard() {
		for (int i = 0; i <= MAX_RANGE; i++) {
			printEmptyFrame();
		}
		System.out.print("|\n");
	}

	public static void printBaseAllBoard(Users users) {
		for (int i = 0; i < users.size(); i++) {
			printBaseUpBoard();
			printBasePinBoard(users.getName(i));
			printBaseScoreBoard();
		}
	}

}
