package bowling;

import bowling.domain.Game;
import bowling.view.Input;
import bowling.view.Print;

public class Main {
	public static void main(String[] args) {
		String name = Input.inputName();
		Print.printBaseUpBoard();
		Print.printBasePinBoard(name);
		Print.printBaseScoreBoard();
		gameStart(name);
	}

	public static void gameStart(String name) {
		Game game = Game.of();
		for (int frameNum = 1; frameNum <= Game.LAST_FRAME; frameNum++) {
			throwBall(name, frameNum, game);
		}
	}

	public static void throwBall(String name, int frameNum, Game game) {
		for (int throwTime = 1; throwTime <= checkThrowRange(frameNum); throwTime++) {
			if (!game.addScore(Input.inputThrowScore(frameNum), frameNum, name)) {
				break;
			}
		}
	}

	public static int checkThrowRange(int frameNum) {
		if (frameNum == Game.LAST_FRAME) {
			return 3;
		}
		return 2;
	}
}
