package bowling.player;

import java.util.ArrayList;
import java.util.List;

public class Players {
	private List<Player> players;

	public Players() {
		players = new ArrayList<>();
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

	public Player getPlayer(int no) {
		return players.get(no);
	}
}
