package radder.result;

import java.util.List;
import java.util.Random;

import radder.player.Player;
import radder.player.Players;

public class Result {

	private static final String newLine = System.getProperty("line.separator");

	private Players players;
	private int height;

	public Result(Players players, int radderHeight) {
		this.players = players;
		this.height = radderHeight;
	}

	public StringBuilder show() {
		StringBuilder stringBuiler = new StringBuilder();
		List<Player> players = this.players.getPlayers();
		for (int i = 0; i < height; i++) {
			stringBuiler.append(width(players));
			stringBuiler.append(newLine);
		}
		for (Player player : players) {
			stringBuiler.append(player.getName());
			stringBuiler.append("      ");
		}
		return stringBuiler;
	}

	private StringBuilder width(List<Player> players) {
		StringBuilder stringBuiler = new StringBuilder();
		for (int i = 0; i < players.size(); i++) {
			stringBuiler.append(findPlayer(players, i).getRadder());
			stringBuiler.append(widthCreate(findPlayer(players, i).getNo(), players.size() - 1));
		}
		return stringBuiler;
	}

	private Player findPlayer(List<Player> players, int i) {
		return players.get(i);
	}

	private String widthCreate(int i, int no) {
		Random random = new Random();
		int x = random.nextInt(100) + 1;
		if (x % (i + 2) == 1 || i == no) {
			return "     ";
		}
		return "-----";
	}

}
