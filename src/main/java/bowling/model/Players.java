package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Players {
	private List<Player> players;
	private int index;
	private int round;
	private boolean isEnd;

	public Players() {
		players = new ArrayList<>();
		index = 0;
		isEnd = false;
	}

	public void add(String name) {
		players.add(new Player(name));
	}

	public void bowl(int knockedPins) {
		Player player = findPlayer();
		round = player.getNowNo();
		manageIndex(player.bowl(knockedPins));
		player.calculate();
	}

	private void manageIndex(boolean endFrame) {
		if (endFrame) {
			index++;
		}
		checkIndex();
	}

	private void checkIndex() {
		if (index == players.size()) {
			index = 0;
			checkEnd();
		}
	}

	private void checkEnd() {
		if (round == 10) {
			isEnd = true;
		}
	}

	public boolean isEnd() {
		return isEnd;
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
