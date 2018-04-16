package bowling;

import bowling.domain.Game;
import bowling.domain.Pin;
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
		for (int frameNum = 1; frameNum <= Print.LAST_FRAME; frameNum++) {
			Pin pin = throwBall(name, frameNum, game);
			game.addFrame(frameNum, pin);
		}
	}

	public static Pin throwBall(String name, int frameNum, Game game) {
		Pin pin = Pin.of();

		int throwRange = 2;
		if (frameNum == Print.LAST_FRAME) {
			throwRange = 3;
		}

		for (int throwTime = 1; throwTime <= throwRange; throwTime++) {
			int inputScore = Input.inputThrowScore(frameNum);
			pin.addScore(inputScore);
			game.updateScore(inputScore, pin, frameNum);
			Print.printFrame(pin, name, frameNum, game);
			if (!check(frameNum, pin)) {
				return pin;
			}
		}
		return pin;
	}

	public static Boolean check(int frameNum, Pin pin) {
		if (frameNum != Print.LAST_FRAME && pin.isStrike()) {
			return false;
		}
		if (frameNum == Print.LAST_FRAME && pin.checkNotThird()) {
			return false;
		}
		return true;
	}
}
