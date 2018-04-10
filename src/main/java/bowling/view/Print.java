package bowling.view;

import bowling.domain.Game;
import bowling.domain.Score;

public class Print {

	private static final int STRIKE = 10;
	private static final int LAST_FRAME = 10;
	private static final int MAX_RANGE = 10;

	public static void startBowlingGame(String name, int frameNum, Game game) {
		Score score = Score.of();
		if (frameNum == LAST_FRAME) {
			printLastFrame(score, name, frameNum, game);
			game.addLastFrame(frameNum, score);
			return;
		}
		printNormalFrame(score, name, frameNum, game);
		game.addNormalFrame(frameNum, score);
	}

	public static void printNormalFrame(Score score, String name, int frameNum, Game game) {
		for (int throwTime = 1; throwTime <= 2; throwTime++) {
			int inputScore = Input.inputThrowScore(frameNum);
			score.addScore(inputScore);
			Print.printBaseUpBoard();
			System.out.print("|   " + name + "    ");
			Print.printScoreBoard(frameNum, game, score);
			if (inputScore == STRIKE) {
				return;
			}
		}
	}

	public static void printLastFrame(Score score, String name, int frameNum, Game game) {
		for (int throwTime = 1; throwTime <= 3; throwTime++) {
			int inputScore = Input.inputThrowScore(frameNum);
			score.addScore(inputScore);
			Print.printBaseUpBoard();
			System.out.print("|   " + name + "    ");
			Print.printScoreBoard(frameNum, game, score);
			if (score.checkNotThird()) {
				return;
			}
		}
	}

	public static void printScoreBoard(int frameNum, Game game, Score score) {
		if (frameNum == 1) {
			printFirstFrame(score);
			return;
		}
		if (frameNum == LAST_FRAME) {
			printLastFrame(frameNum, game, score);
			return;
		}
		printNormalFrame(frameNum, game, score);
	}

	public static void printFirstFrame(Score score) {
		printScore(score);
		for (int i = 2; i <= MAX_RANGE; i++) {
			printEmptyFrame();
		}
		System.out.print("|\n");
	}

	public static void printNormalFrame(int frameNum, Game game, Score score) {
		for (int j = 0; j < game.size(); j++) {
			System.out.print("|   ");
			System.out.print(game.getDownPin(j));
			System.out.print("    ");
		}
		printScore(score);
		for (int i = 0; i < MAX_RANGE - frameNum; i++) {
			printEmptyFrame();
		}
		System.out.print("|\n");
	}

	public static void printLastFrame(int frameNum, Game game, Score score) {
		for (int j = 0; j < game.size(); j++) {
			System.out.print("|   ");
			System.out.print(game.getDownPin(j));
			System.out.print("    ");
		}
		System.out.print("|   " + score.checkLastScore() + "    ");
		System.out.print("|\n");
	}

	public static void printScore(Score score) {
		System.out.print("|   " + score.checkScore() + "    ");
	}

	public static void printEmptyFrame() {
		System.out.print("|    " + "  " + "    ");
	}

	public static void printBaseUpBoard() {
		System.out.print("|   Name   ");
		for (int i = 1; i < MAX_RANGE; i++) {
			System.out.print("|    " + "0" + i + "    ");
		}
		System.out.print("|   10     ");
		System.out.print("|\n");
	}

	public static void printBaseScoreBoard(String name) {
		System.out.print("|   " + name + "    ");
		for (int i = 1; i < MAX_RANGE; i++) {
			printEmptyFrame();
		}
		System.out.print("|          ");
		System.out.print("|\n");
	}

}
