package bowling.view;

import bowling.domain.Game;
import bowling.domain.Pin;

public class Print {

	public static final int LAST_FRAME = 10;
	private static final int MAX_RANGE = 10;

	public static void printFrame(Pin pin, String name, int frameNum, Game game) {
		printBaseUpBoard();
		System.out.print("|   " + name + "    ");
		printPinBoard(frameNum, game, pin);
		printScoreBoard(pin, frameNum, game);
	}

	public static void printScoreBoard(Pin pin, int frameNum, Game game) {
		printEmptyFrame();

		if (frameNum == 1) {
			printFirstScore(pin);
			printEmptyScore(game);
			return;
		}

		for (int i = 0; i < game.size(); i++) {
			if (!game.getScore(i).canCalculateScore()) {
				printScore(game.getScore(i).getScore());
			}
		}
		printNowScore(pin, game);
		printEmptyScore(game);
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

	public static void printPinBoard(int frameNum, Game game, Pin pin) {
		if (frameNum == 1) {
			printFirstFrame(pin);
			return;
		}
		if (frameNum == LAST_FRAME) {
			printLastFrame(frameNum, game, pin);
			return;
		}
		printNormalFrame(frameNum, game, pin);
	}

	public static void printFirstFrame(Pin pin) {
		printPin(pin);
		for (int i = 2; i <= MAX_RANGE; i++) {
			printEmptyFrame();
		}
		System.out.print("|\n");
	}

	public static void printNormalFrame(int frameNum, Game game, Pin pin) {
		printBeforeFrame(game);
		printPin(pin);
		for (int i = 0; i < MAX_RANGE - frameNum; i++) {
			printEmptyFrame();
		}
		System.out.print("|\n");
	}

	public static void printLastFrame(int frameNum, Game game, Pin pin) {
		printBeforeFrame(game);
		System.out.print("|   " + pin.checkLastScore() + "    ");
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
		System.out.print("|   " + pin.checkScore() + "    ");
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
		System.out.print("|   " + LAST_FRAME + "     ");
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

}
