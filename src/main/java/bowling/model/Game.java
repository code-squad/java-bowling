package bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Player> players = new ArrayList<>();
	
	public Game(List<String> names) {
		for(String name : names) {
			players.add(new Player(name));
		}
	}
	
	public int getFrameNo() {
		return getLastPlayer().getFrameNo();
	}
	
	public Game play(int pin) {
		Player player = presentPlayer();
		player.play(pin);
		return this;
	}
	
	protected Player presentPlayer() {
		return players.stream().filter(player -> player.getFrameNo() == getFrameNo()).findFirst().orElse(players.get(0));
	}
	
	public boolean isEnd() {
		return getLastPlayer().isEnd();
	}
	
	private Player getLastPlayer() {
		return players.get(players.size() -1);
	}

	public Board createBoard() {
		Board board = new Board();
		for(Player player : players) {
			board.add(player.getResult(board));
		}
		return board;
	}
}