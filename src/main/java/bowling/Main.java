package bowling;

import bowling.domain.Game;
import bowling.view.Input;
import bowling.view.Print;

public class Main {

	public static void main(String[] args) {

		String name = Input.inputName();
		Print.printBaseUpBoard();
		Print.printBaseScoreBoard(name);
		gameStart(name);
	}

	public static void gameStart(String name) {
		Game game = Game.of();
		for (int frameNum = 1; frameNum <= 10; frameNum++) {
			Print.startBowlingGame(name, frameNum, game);
		}
	}
}
