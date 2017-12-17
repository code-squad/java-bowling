package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Player> players = new ArrayList<>();
	private int playerCount = 0;
	private Player currentPlayer;

	public Game(List<String> names) {
		for (String name : names) {
			players.add(create(name));
		}
		currentPlayer = players.get(0);
	}

	public Player create(String name) {
		return new Player(name);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void choose() {
		if (findPlayer(playerCount).isEnd()) {
			chooseNextPlayer();
			return;
		}
		currentPlayer = findPlayer(playerCount);
	}

	private void chooseNextPlayer() {
		if (isLastPlayer()) {
			playerCount = 0;
			currentPlayer = findPlayer(playerCount);
			return;
		}
		playerCount++;
		currentPlayer = findPlayer(playerCount);
	}

	public void play(Pin pin) {
		currentPlayer.bowl(pin);
		choose();
	}

	public List<Status> getPlayerStatus(Player player) {
		return player.makeStatus();
	}

	public List<String> getPlayerScore(Player player) {
		return player.getTotal();
	}

	public boolean isLastPlayer() {
		if (this.playerCount == players.size() - 1) {
			return true;
		}
		return false;
	}

	public Player findLastPlayer() {
		return findPlayer(players.size() - 1);
	}

	private Player findPlayer(int index) {
		return this.players.get(index);
	}

	public List<Player> getPlayers() {
		return players;
	}

}
