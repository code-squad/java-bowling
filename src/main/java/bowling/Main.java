package bowling;

import bowling.domain.Game;
import bowling.view.Input;
import bowling.view.Print;

public class Main {
	public static void main(String[] args) {

		String name = Input.getName();
		Print.printBaseBoard(name);

		Game game = Game.of(name);

		Print.printGame(game, name);

	}
}
