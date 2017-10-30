package bowling.utils;

import bowling.player.Player;
import bowling.player.Players;

public class Utils {

	public static Players playerCreate(UtilsNumber utilsNumber) {
		Players players = new Players();
		for (int i = 0; i < utilsNumber.getPlayerCount(); i++) {
			players.add(new Player(i));
		}
		return players;
	}

	public static UtilsNumber inputPlayerCount(int playerCount) {
		UtilsNumber utilsNumber = new UtilsNumber();
		utilsNumber.setPlayerCount(playerCount);
		return utilsNumber;
	}
}
