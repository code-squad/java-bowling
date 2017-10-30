package bowling.utils;

import bowling.player.Player;
import bowling.player.Players;
import bowling.view.BowlingFormView;

public class Utils {

	public static UtilsNumber inputPlayerCount(int playerCount) {
		UtilsNumber utilsNumber = new UtilsNumber();
		utilsNumber.setPlayerCount(playerCount);
		return utilsNumber;
	}

	public static Player playerCreate() {
		return new Player(BowlingFormView.inputName());
	}
}
