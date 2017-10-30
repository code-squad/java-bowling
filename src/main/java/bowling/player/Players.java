package bowling.player;

import java.util.ArrayList;
import java.util.List;

public class Players {
	private List<Player> players;

	public Players() {
		List<Player> players = new ArrayList<>();
		this.players = players;
	}

	public int size() {
		return players.size();
	}

	public void add(Player player) {
		players.add(player);
	}

	public List<Player> getPlayers() {
		return players;
	}

}
