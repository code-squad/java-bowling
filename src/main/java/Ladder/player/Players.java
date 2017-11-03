package Ladder.player;

import java.util.ArrayList;
import java.util.List;

public class Players {
	List<Player> players;

	public Players(String playersInput) {
		players = new ArrayList<>();
		playerAdd(playersInput);
	}

	public int getCount() {
		return players.size();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public static Players create(String playersInput) {
		return new Players(playersInput);
	}

	private void playerAdd(String playersInput) {
		String[] players = playersInput.split(",");
		for (int i = 0; i < players.length; i++) {
			this.players.add(new Player(i, players[i]));
		}
	}
}
