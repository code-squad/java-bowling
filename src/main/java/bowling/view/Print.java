package bowling.view;

import bowling.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class Print {

	public static final List<String> BASE_BOARD = makeBaseUpBoard();

	public static Game printGame(Game game, String name) {
		for (int frameNum = 1; frameNum <= 10; frameNum++) {
			game = printGame(game, frameNum, name);
			Print.printScoreBoard(game, name);
		}
		return game;
	}

	public static Game printGame(Game game, int frameNum, String name) {
		int range = 2;
		if (frameNum == 10) {
			range = 3;
		}
		for (int throwTime = 1; throwTime <= range; throwTime++) {
			if (!game.addFrame(Input.inputThrowScore(frameNum), frameNum, throwTime)) {
				return game;
			}
			Print.printScoreBoard(game, name);
		}
		return game;
	}

	public static void printScoreBoard(Game game, String name) {
		printBaseUpBoard();
		System.out.print("|   " + name + "    ");
		for (int i = 1; i <= 10; i++) {
			System.out.print("|   ");
			System.out.print(game.getDownPin(i));
			System.out.print("  ");
		}
		System.out.print("|\n");
	}

	public static void printBaseBoard(String name) {
		Print.printBaseUpBoard();
		Print.printBaseDownBoard(name);
	}

	public static void printBaseUpBoard() {
		for (String baseFrame : BASE_BOARD) {
			System.out.print("|   ");
			System.out.print(baseFrame);
			System.out.print("   ");
		}
		System.out.print("|\n");
	}

	public static void printBaseDownBoard(String name) {
		System.out.print("|   " + name + "    ");
		for (int i = 0; i < 10; i++) {
			System.out.print("|   ");
			System.out.print("  ");
			System.out.print("   ");
		}
		System.out.print("|\n");
	}

	private static List<String> makeBaseUpBoard() {
		List<String> baseFrame = new ArrayList<>();
		baseFrame.add("Name");
		for (int i = 1; i < 10; i++) {
			baseFrame.add("0" + i);
		}
		baseFrame.add("10");
		return baseFrame;
	}

}
