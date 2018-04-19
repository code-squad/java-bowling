package bowling;

import bowling.domain.Game;
import bowling.domain.Users;
import bowling.view.Input;
import bowling.view.Print;

public class Main {
	public static void main(String[] args) {
		Users users = Input.makeUsers();
		Print.printBaseAllBoard(users);
		gameStart(users);
	}

	public static void gameStart(Users users) {
		for (int frameNum = 1; frameNum <= Game.LAST_FRAME; frameNum++) {
			throwBall(users, frameNum);
		}
	}

	public static void throwBall(Users users, int frameNum) {
		for (int i = 0; i < users.size(); i++) {
			throwBall(users, frameNum, i);
		}
	}

	public static void throwBall(Users users, int frameNum, int i) {
		for (int throwTime = 1; throwTime <= checkThrowRange(frameNum); throwTime++) {
			users.addScore(i, Input.inputThrowScore(users.getName(i), frameNum));
			Print.printFrame(users, frameNum);
			if (!users.getGame(i).canNextFrame(frameNum)) {
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
