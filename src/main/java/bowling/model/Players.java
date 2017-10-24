package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Players {
	private List<Player> players;
	private int index;
	private int round;

	public Players() {
		players = new ArrayList<>();
		index = 0;
		round = 1;
	}

	public void add(String name) {
		players.add(new Player(name));
	}

	public void bowl(int knockedPins) {
		Player player = findPlayer();
		index += player.bowl(knockedPins);
		player.calculate();
		checkIndex();
	}

	private void checkIndex() {
		if (index == players.size()) {
			index = 0;
			round++;
		}
	}

	public boolean isEnd() {
		return round == 11;
	}

	public Result getResult(int no) {
		Player player = findPlayer(no);
		player.calculate();
		return player.getResult();
	}

	public String getPalyerName(int no) {
		return findPlayer(no).getName();
	}

	private Player findPlayer() {
		return players.get(index);
	}

	private Player findPlayer(int no) {
		return players.get(no);
	}

	public int getSize() {
		return players.size();
	}
}
